package com.aca.arminearzumanyan.homeworks.manager;

import com.aca.arminearzumanyan.homeworks.exceptions.NotEnoughItemException;
import com.aca.arminearzumanyan.homeworks.items.gadget.*;

import java.io.*;
import java.nio.file.Paths;
import java.util.*;
import java.util.logging.Logger;

public class GadgetStoreManager {

    private static final Logger logger = Logger.getGlobal();
    private DataConverter dataConverter = new DataConverter();
    private Map<Integer, Gadget> allItems = dataConverter.generateGadgetInstanceList();
    private int soledItemPrice = 0;

    private void writeInFile(Gadget gadget, File file) {
        try (FileWriter fw = new FileWriter(file, true)) {
            logger.info("Enter into try");
            fw.write(gadget.getName() + ",  " + "price: " + gadget.getPrice() + "\n");
        } catch (IOException ex) {
            logger.severe("An error occurred." + ex.getMessage());
            ex.printStackTrace();
        }
    }

    public void changePrice(Gadget gadget, int newPrice) {
        gadget.setPrice(newPrice);
    }

    public boolean isGadgetWorking() {
        Random random = new Random();
        return random.nextBoolean();
    }

    public void getNotWorkingGadgets() {
        for (Integer i : allItems.keySet()) {
            Gadget gadget = allItems.get(i);
            int l = gadget.getCount();
            for (int j = 1; j < l; j++) {
                Gadget.turnOnGadget(gadget);
                if (isGadgetWorking()) {
                    logger.info("Gadget is working");
                    logger.info(gadget.toString());
                } else {
                    logger.info("Gadget is not working");
                    gadget.setCount(gadget.getCount() - 1);
                }
            }

        }
    }

    public Map<Integer, Gadget> getAudioGadgets() {
        Map<Integer, Gadget> audioGadgets = new HashMap<>();
        for (Integer i : allItems.keySet()) {
            if (allItems.get(i) instanceof AudioRecorder) {
                audioGadgets.put(i, allItems.get(i));
            }
        }
        return audioGadgets;
    }

    public Map<Integer, Gadget> getVideoGadgets() {
        Map<Integer, Gadget> videoGadgets = new HashMap<>();
        for (Integer i : allItems.keySet()) {
            if (allItems.get(i) instanceof VideoRecorder) {
                videoGadgets.put(i, allItems.get(i));
            }
        }
        return videoGadgets;
    }

    public void sellItem(Integer code) {
        String tradingFilePath = "files/Trading.CSV";
        File file = Paths.get(tradingFilePath).toFile();
        Gadget gadget = allItems.get(code);
        if (gadget.getCount() == 0) {
            throw new NotEnoughItemException();
        } else {
            for (Integer i : allItems.keySet()) {
                if (i.equals(code)) {
                    gadget.setCount(gadget.getCount() - 1);
                    writeInFile(gadget, file);
                    break;
                }
            }
            soledItemPrice += gadget.getPrice();
        }
    }

    public int sumPrice() {
        int sum = 0;
        for (Integer i : allItems.keySet()) {
            sum += allItems.get(i).getPrice() * allItems.get(i).getCount();
        }
        return sum;
    }

    public Map<Integer, Gadget> getAllItems() {
        return allItems;
    }

    public int getSoledItemPrice() {
        return soledItemPrice;
    }

}
