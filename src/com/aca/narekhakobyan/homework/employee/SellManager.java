package com.aca.narekhakobyan.homework.employee;

import com.aca.narekhakobyan.homework.employee.functionality.Employee;
import com.aca.narekhakobyan.homework.employee.functionality.Management;
import com.aca.narekhakobyan.homework.items.concepts.*;
import com.aca.narekhakobyan.homework.items.functionality.Video;
import com.aca.narekhakobyan.homework.items.functionality.Voice;
import com.aca.narekhakobyan.homework.items.models.*;
import javafx.util.Pair;

import java.io.FileWriter;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;
import java.util.Random;
import java.util.Scanner;
import java.util.logging.FileHandler;
import java.util.logging.Logger;

public class SellManager implements Management, Employee {
    private int soldAMD = 0;
    private int stockAMD = 0;
    private List<Gadget> gadgets;
    private List<Gadget> nonWorkingGadget = new ArrayList<>();
    private Logger logger = Logger.getLogger("tradeLog");
    private String pathTradings = "src\\com\\aca\\narekhakobyan\\homework\\output\\trading.csv";
    private String pathInStock = "src\\com\\aca\\narekhakobyan\\homework\\output\\inStock.csv";
    private String pathNonWorking = "src\\com\\aca\\narekhakobyan\\homework\\output\\nonWorkingGadgets.csv";
    private String pathByType = "src\\com\\aca\\narekhakobyan\\homework\\output\\filteredGadgetsByType.csv";

    public SellManager(List<Gadget> gadgets) {
        this.gadgets = gadgets;
        calculateStockAMD();
    }

    private void calculateStockAMD() {
        for (Gadget gadget : this.gadgets) {
            this.stockAMD += gadget.getPrice() * gadget.getCount();
        }
    }

    @Override
    public void listOfItems() {
        FileWriter fileWriter = null;
        try {
            fileWriter = new FileWriter(pathInStock);
            fileWriter.write("");
            fileWriter.close();
        } catch (IOException e) {
            e.printStackTrace();
        }
        for (Gadget gadget : this.gadgets) {
            gadget.print(pathInStock);
        }
    }

    public void listOfItemsVideoGadgets() {
        FileWriter fileWriter = null;
        try {
            fileWriter = new FileWriter(pathByType);
            fileWriter.write("");
            fileWriter.close();
        } catch (IOException e) {
            e.printStackTrace();
        }
        for (Gadget gadget : gadgets) {
            if (gadget instanceof Video) {
                gadget.print(pathByType);
            }
        }
    }

    public void listOfItemsRecordGadgets() {
        FileWriter fileWriter = null;
        try {
            fileWriter = new FileWriter(pathByType);
            fileWriter.write("");
            fileWriter.close();
        } catch (IOException e) {
            e.printStackTrace();
        }
        for (Gadget gadget : gadgets) {
            if (gadget instanceof Voice) {
                gadget.print(pathByType);
            }
        }
    }

    @Override
    public void sellItem(String name, Integer count) {
        FileHandler tradeLog = null;
        try {
            tradeLog = new FileHandler(pathTradings);
        } catch (IOException e) {
            Logger logger = Logger.getLogger("Errors");
            FileHandler errorsLog = null;
            try {
                errorsLog = new FileHandler("src\\com\\aca\\narekhakobyan\\homework\\errors\\errors.log", true);
                logger.addHandler(errorsLog);
                logger.severe("Incorrect path for trading");
            }
            catch (IOException e1){
                e1.printStackTrace();
            }
        }
        logger.addHandler(tradeLog);
        for (Gadget gadget : gadgets) {
            if (gadget.getName().equals(name)) {
                if (gadget.getCount() >= count) {
                    soldAMD += count * gadget.getPrice();
                    gadget.setCount(gadget.getCount() - count);
                    stockAMD -= gadget.getPrice() * count;
                    logger.info(gadget.toString());
                    return;
                } else {
                    Logger logger = Logger.getLogger("Errors");
                    FileHandler errorsLog = null;
                    try {
                        errorsLog = new FileHandler("src\\com\\aca\\narekhakobyan\\homework\\errors\\errors.log", true);
                        logger.addHandler(errorsLog);
                        logger.severe("Sorry. There are only %d items.\n" + gadget.getCount());
                    }
                    catch (IOException e){
                        e.printStackTrace();
                    }
                }
            }
        }
    }

    @Override
    public void sellItem(String name) {
        sellItem(name, 1);
    }

    public void addItem(Object gadgetObject) {
        Pair<Boolean, Integer> isGadgetExistVar = isGadgetExist(gadgetObject);
        if (isGadgetExistVar.getKey()) {
            Integer tempCount = gadgets.get(isGadgetExistVar.getValue()).getCount();
            gadgets.get(isGadgetExistVar.getValue()).setCount(tempCount + ((Gadget)gadgetObject).getCount());
            stockAMD += gadgets.get(isGadgetExistVar.getValue()).getPrice() * tempCount;
        } else {
            gadgets.add((Gadget) gadgetObject);
            stockAMD += ((Gadget) gadgetObject).getPrice() * ((Gadget) gadgetObject).getCount();
        }
    }

    private Pair<Boolean, Integer> isGadgetExist(Object gadgetObject) {
        Pair<Boolean, Integer> retVal;
        int index = -1;
        for (Gadget gadget : gadgets) {
            index++;
            if (gadget.equals(gadgetObject)) {
                retVal = new Pair<>(Boolean.TRUE, index);
                return retVal;
            }
        }
        retVal = new Pair<>(Boolean.FALSE, index);
        return retVal;
    }

    private boolean isCorrectPrice(Integer price) {
        return price >= 0;
    }

    @Override
    public void changePrice(Object gadgetObject, Integer price) {
        for (Gadget gadget : gadgets) {
            if (gadget.getClass().equals(gadgetObject.getClass())) {
                if (price < 0) {
                    Logger logger = Logger.getLogger("Errors");
                    FileHandler errorsLog = null;
                    try {
                        errorsLog = new FileHandler("src\\com\\aca\\narekhakobyan\\homework\\errors\\errors.log", true);
                        logger.addHandler(errorsLog);
                        logger.severe("Incorrect price. Price should be non-negative");
                    }
                    catch (IOException e){
                        e.printStackTrace();
                    }
                }
                stockAMD += gadget.getCount() * (price - gadget.getPrice());

            }
        }
    }

    public void turnOn() {
        Random rand = new Random();
        boolean flag;
        int workCount = 0;
        int removeCount = 0;
        int index;

        for (Gadget gadget : gadgets) {
            try {
                this.nonWorkingGadget.add((Gadget)gadget.clone());
            } catch (CloneNotSupportedException e) {
                e.printStackTrace();
             }
        }

        for (Gadget gadget : gadgets) {
            for (int i = 0; i < gadget.getCount(); ++i) {
                flag = rand.nextBoolean();
                if (flag) {
                    workCount++;
                }
            }
            if (workCount == gadget.getCount()) {
                nonWorkingGadget.remove(gadget);
                removeCount++;
            } else if (workCount < gadget.getCount()) {
                index = gadgets.indexOf(gadget);
                nonWorkingGadget.get(index - removeCount).setCount(gadget.getCount() - workCount);
                gadget.setCount(workCount);
            }
            workCount = 0;
        }

        this.printListOfNonWorkingGadgets();
    }

    public void addFromFile(Class... classes) {
        for (Class cl : classes) {

            try {
                if (PenRecord.class == cl) {
                    PenRecord penRecord = PenRecord.initFromFile();
                    if(penRecord != null)
                        this.addItem(penRecord);
                }

                if (PenVideo.class == cl) {
                    PenVideo penVideo = PenVideo.initFromFile();
                    if(penVideo != null)
                        this.addItem(penVideo);
                }

                if (USBFlashRecord.class == cl) {

                    USBFlashRecord usbFlashRecord = USBFlashRecord.initFromFile();
                    if(usbFlashRecord != null)
                        this.addItem(usbFlashRecord);
                }
                if (USBFlashVideo.class == cl) {
                    USBFlashVideo usbFlashVideo = USBFlashVideo.initFromFile();
                    if(usbFlashVideo != null)
                        this.addItem(USBFlashVideo.initFromFile());
                }

                if (Watch.class == cl) {
                    Watch watch = Watch.initFromFile();
                    if(watch != null)
                        this.addItem(Watch.initFromFile());
                }
            } catch (NullPointerException e) {
                e.printStackTrace();
            }
        }
    }

    private void printListOfNonWorkingGadgets() {
        for (Gadget gadget : nonWorkingGadget) {
                gadget.print(pathNonWorking);
        }
    }

    @Override
    public int getStockAMD() {
        return stockAMD;
    }

    @Override
    public int getSoldAMD() {
        return soldAMD;
    }

    @Override
    public void removeItem(Object gadgetObject) {
        gadgets.remove((Gadget)gadgetObject);
    }
}
