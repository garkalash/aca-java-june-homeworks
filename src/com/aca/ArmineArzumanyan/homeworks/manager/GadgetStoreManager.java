package com.aca.arminearzumanyan.homeworks.manager;


import com.aca.arminearzumanyan.homeworks.exceptions.FileFormatException;
import com.aca.arminearzumanyan.homeworks.items.gadget.*;

import java.io.*;
import java.lang.reflect.InvocationTargetException;
import java.nio.file.Paths;
import java.util.*;
import java.util.logging.Logger;

public class GadgetStoreManager {


    Scanner scanner = new Scanner(System.in);
    private static final Logger logger = Logger.getGlobal();
    private Map<Integer, Gadget> allItems = new HashMap<>();
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

    private ArrayList<String> takeProductFromFile() {
        String productFilePath = "files/Product.CSV";
        ArrayList<String> productProperties = new ArrayList<>();
        try (BufferedReader br = new BufferedReader(new FileReader(Paths.get(productFilePath).toFile()))) {
            logger.info("Enter into try");
            String line = br.readLine();
            while (line != null) {
                productProperties.add(line);
                line = br.readLine();
            }
        } catch (IOException ex) {
            logger.severe("An error occurred." + ex.getMessage());
            ex.printStackTrace();
        }
        return productProperties;
    }


    public void createGadget1()  {
        ArrayList<String> productsProperty = takeProductFromFile();

        List<Class<? extends Gadget>> classList = new ArrayList<>();
        classList.add(PenAudioRecorder.class);
        classList.add(PenVideoRecorder.class);
        classList.add(UsbAudioRecorder.class);
        classList.add(UsbVideoRecorder.class);
        classList.add(Watch.class);

        for (int i = 0; i < productsProperty.size(); i++) {
            String[] gadgetProperty = productsProperty.get(i).split(",");
            if (gadgetProperty.length >= 5) {
                String name = gadgetProperty[1];
                int count = Integer.parseInt(gadgetProperty[2]);
                int price = Integer.parseInt(gadgetProperty[3]);
                int recDuration = Integer.parseInt(gadgetProperty[4]);
                Integer code = Integer.parseInt(gadgetProperty[0]);
                int memoryInGb = 0;
                if (gadgetProperty.length == 6) {
                    memoryInGb = Integer.parseInt(gadgetProperty[5]);
                }
                for (Class<? extends Gadget> aClass : classList) {
                    if (name.equals(aClass.getSimpleName())) {
                        Gadget gadget = null;
                        if (memoryInGb == 0) {
                            Class[] constructorParameters = new Class[]{String.class, int.class, int.class};
                            try {
                                gadget = aClass.getConstructor(constructorParameters).newInstance(name, price, recDuration);
                            } catch (ReflectiveOperationException ex) {
                                logger.severe("An error occurred." + ex.getMessage());
                                ex.printStackTrace();
                            }
                            gadget.setCount(count);
                            allItems.put(code, gadget);
                            break;
                        } else {
                            Class[] parameters = new Class[]{String.class, int.class, int.class, int.class};
                            try {
                                gadget = aClass.getConstructor(parameters).newInstance(name, price, recDuration, memoryInGb);
                            } catch (ReflectiveOperationException ex) {
                                logger.severe("An error occurred." + ex.getMessage());
                                ex.printStackTrace();
                            }
                            gadget.setCount(count);
                            allItems.put(code, gadget);
                            break;
                        }
                    }
                }
            }
        }
    }


    public void createGadget() {
        ArrayList<String> productsProperty = takeProductFromFile();
        for (int i = 0; i < productsProperty.size(); i++) {
            String[] gadgetProperty = productsProperty.get(i).split(",");
            if (gadgetProperty.length >= 5) {
                String name = gadgetProperty[1];
                int count = Integer.parseInt(gadgetProperty[2]);
                int price = Integer.parseInt(gadgetProperty[3]);
                int recDuration = Integer.parseInt(gadgetProperty[4]);
                Integer code = Integer.parseInt(gadgetProperty[0]);
                int memoryInGb = 0;
                if (gadgetProperty.length == 6) {
                    memoryInGb = Integer.parseInt(gadgetProperty[5]);
                }
                switch (name) {
                    case "PenVideoRecorder":
                        PenVideoRecorder penVideoRecorder = new PenVideoRecorder(name, price, recDuration);
                        penVideoRecorder.setCount(count);
                        allItems.put(code, penVideoRecorder);
                        break;
                    case "PenAudioRecorder":
                        PenAudioRecorder penAudioRecorder = new PenAudioRecorder(name, price, recDuration, memoryInGb);
                        penAudioRecorder.setCount(count);
                        allItems.put(code, penAudioRecorder);
                        break;
                    case "USBVideoRecorder":
                        UsbVideoRecorder usbVideoRecorder = new UsbVideoRecorder(name, price, recDuration);
                        usbVideoRecorder.setCount(count);
                        allItems.put(code, usbVideoRecorder);
                        break;
                    case "USBAudioRecorder":
                        UsbAudioRecorder usbAudioRecorder = new UsbAudioRecorder(name, price, recDuration, memoryInGb);
                        usbAudioRecorder.setCount(count);
                        allItems.put(code, usbAudioRecorder);
                        break;
                    case "Watch":
                        Watch watch = new Watch(name, price, recDuration, memoryInGb);
                        watch.setCount(count);
                        allItems.put(code, watch);
                }
            } else {
                throw new FileFormatException("Wrong file");
            }
        }
    }

    public void changePrice(Gadget gadget, int newPrice) {
        gadget.setPrice(newPrice);
    }

    public boolean isGadgetWorking() {
        Random random = new Random();
        int x = random.nextInt(100);
        return x % 2 == 0;
    }

    public void getNotWorkingGadgets() {

        String notWorkingGadgetsFilePath = "files/NotWorkingGadgets.CSV";
        File file = Paths.get(notWorkingGadgetsFilePath).toFile();

        for (Integer i : allItems.keySet()) {
            Gadget gadget = allItems.get(i);
            int l = gadget.getCount();
            for (int j = 1; j < l; j++) {
                gadget.turnOnGadget();
                if (isGadgetWorking()) {
                    logger.info("Gadget is working");
                    logger.info(gadget.toString());
                } else {
                    logger.info("Gadget is not working");
                    writeInFile(gadget, file);
                    gadget.setCount(gadget.getCount() - 1);
                }
            }

        }
    }

    public Map<Integer, Gadget> getAudioGadgets(Map<Integer, Gadget> allItems) {
        Map<Integer, Gadget> audioGadgets = new HashMap<>();
        for (Integer i : allItems.keySet()) {
            if (allItems.get(i) instanceof AudioRecorder) {
                audioGadgets.put(i, allItems.get(i));
            }
        }
        return audioGadgets;
    }

    public Map<Integer, Gadget> getVideoGadgets(Map<Integer, Gadget> allItems) {
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
            logger.info("You don't have " + gadget.getName() + " in your stock");
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

    public int sumPrice(Map<Integer, Gadget> allItems) {
        int sum = 0;
        for (Integer i : allItems.keySet()) {
            sum += allItems.get(i).getPrice() * allItems.get(i).getCount();
        }
        return sum;
    }

    public int getIntegerFromUser() {
        try {
            return scanner.nextInt();
        } catch (InputMismatchException ex) {
            System.out.println("Wrong input");
            logger.severe("Wrong input. Exception occurred " + ex.getMessage());
            return 0;
        }
    }

    public Map<Integer, Gadget> getAllItems() {
        return allItems;
    }


    public void setAllItems(Map<Integer, Gadget> allItems) {
        this.allItems = allItems;
    }


    public int getSoledItemPrice() {
        return soledItemPrice;
    }

}
