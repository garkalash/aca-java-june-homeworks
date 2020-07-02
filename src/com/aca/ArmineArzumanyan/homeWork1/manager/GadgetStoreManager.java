package com.aca.arminearzumanyan.homework1.manager;


import com.aca.arminearzumanyan.homework1.items.gadget.*;

import java.io.*;
import java.util.*;

public class GadgetStoreManager {

    Scanner scanner = new Scanner(System.in);
    private HashMap<Integer, Gadget> allItems = new HashMap<>();
    private HashMap<Integer, Gadget> soledItems = new HashMap<>();
    private HashMap<Integer, Gadget> videoGadgets = new HashMap<>();
    private HashMap<Integer, Gadget> audioGadgets = new HashMap<>();
    private HashMap<Integer, Gadget> notWorkingGadgets = new HashMap<>();
    private int soledItemPrice = 0;
    private final ArrayList<String> productPropertyLines = new ArrayList<>();
    PenVideoRecorder penVideoRecorder;
    PenAudioRecorder penAudioRecorder;
    UsbVideoRecorder usbVideoRecorder;
    UsbAudioRecorder usbAudioRecorder;
    Watch watch;

    public void putTradingDetails(File fileIn) {
        try (FileWriter fw = new FileWriter(fileIn)) {
            for (Integer i : soledItems.keySet()) {
                Gadget gadget = soledItems.get(i);
                fw.write(gadget.getName() + " ," + gadget.getCount() + ", " + gadget.getPrice() + "   ");
            }
        } catch (IOException e) {
            System.out.println("An error occurred.");
            e.printStackTrace();
        }
    }

    public void takeProductFromFile(File file) {
        try (FileReader fileReader = new FileReader(file); BufferedReader br = new BufferedReader(fileReader)) {
            String line = br.readLine();
            while (line != null) {
                productPropertyLines.add(line);
                line = br.readLine();
            }
        } catch (IOException ex) {
            ex.printStackTrace();
        }
    }

    public void createGadget(String[] gadgetProperty) {
        String name = gadgetProperty[1];
        int count = Integer.parseInt(gadgetProperty[2]);
        int price = Integer.parseInt(gadgetProperty[3]);
        int recDuration = Integer.parseInt(gadgetProperty[4]);
        Integer code = Integer.parseInt(gadgetProperty[0]);
        int memoryInGb = 0;
        if (gadgetProperty.length > 5) {
            memoryInGb = Integer.parseInt(gadgetProperty[5]);
        }
        switch (name) {
            case "PenVideoRecorder":
                penVideoRecorder = new PenVideoRecorder(name, count, price, recDuration);
                allItems.put(code, penVideoRecorder);
                break;
            case "PenAudioRecorder":
                penAudioRecorder = new PenAudioRecorder(name, count, price, recDuration, memoryInGb);
                allItems.put(code, penAudioRecorder);
                break;
            case "USBVideoRecorder":
                usbVideoRecorder = new UsbVideoRecorder(name, count, price, recDuration);
                allItems.put(code, usbVideoRecorder);
                break;
            case "USBAudioRecorder":
                usbAudioRecorder = new UsbAudioRecorder(name, count, price, recDuration, memoryInGb);
                allItems.put(code, usbAudioRecorder);
                break;
            case "Watch":
                watch = new Watch(name, count, price, recDuration, memoryInGb);
                allItems.put(code, watch);
        }

    }

    public ArrayList<String> getProductPropertyLines() {
        return productPropertyLines;
    }

    public void changePrice(Gadget gadget, int newPrice) {
        gadget.setPrice(newPrice);
    }

    public boolean isGadgetWorking() {
        Random random = new Random();
        int x = random.nextInt(100);
        return x % 2 == 0;
    }

    public void turnOnGadget(Gadget gadget) {
        if (gadget.getCount() == 0) {
            System.out.println("You don't have " + gadget.getName() + " in your stock");
        } else {
            if (gadget instanceof VideoRecorder) {
                System.out.println("Press PlayVideoRecording");
            }
            if (gadget instanceof AudioRecorder) {
                System.out.println("Press PlayAudioRecording");
            }
            if (isGadgetWorking()) {
                System.out.println("Gadget is working");
                System.out.println(gadget);
            } else {
                System.out.println("Gadget is not working");
                int x = 1;
                notWorkingGadgets.put(x, gadget);
                x += 1;
                gadget.setCount(gadget.getCount() - 1);
            }
        }
    }

    public HashMap<Integer, Gadget> getAudioGadgetList(HashMap<Integer, Gadget> allItems) {
        for (Integer i : allItems.keySet()) {
            if (allItems.get(i) instanceof AudioRecorder) {
                audioGadgets.put(i, allItems.get(i));
            }
        }
        return audioGadgets;
    }

    public HashMap<Integer, Gadget> getVideoGadgetList(HashMap<Integer, Gadget> allItems) {
        for (Integer i : allItems.keySet()) {
            if (allItems.get(i) instanceof VideoRecorder) {
                videoGadgets.put(i, allItems.get(i));
            }
        }
        return videoGadgets;
    }

    public void sellItem(Integer code) {
        Gadget gadget = allItems.get(code);
        if (gadget.getCount() == 0) {
            System.out.println("You don't have " + gadget.getName() + " in your stock");
        } else {
            for (Integer i : allItems.keySet()) {
                if (i.equals(code)) {
                    gadget.setCount(gadget.getCount() - 1);
                    soledItems.put(i, gadget);
                    break;
                }
            }
            soledItemPrice += gadget.getPrice();
        }
    }

    public int sumPrice(HashMap<Integer, Gadget> allItems) {
        int sum = 0;
        for (Integer i : allItems.keySet()) {
            sum += allItems.get(i).getPrice() * allItems.get(i).getCount();
        }
        return sum;
    }

    public int getIntegerFromUser() {
        try {
            return scanner.nextInt();
        } catch (InputMismatchException e) {
            System.out.println("Wrong input");
            return 0;
        }
    }

    public HashMap<Integer, Gadget> getAllItems() {
        return allItems;
    }

    public void getItemsList(HashMap<Integer, Gadget> allItems) {

        for (Integer i : allItems.keySet()) {

            System.out.println(allItems.get(i) + ": {" + i + "}");
        }
    }

    public void setAllItems(HashMap<Integer, Gadget> allItems) {
        this.allItems = allItems;
    }

    public HashMap<Integer, Gadget> getSoledItems() {
        return soledItems;
    }

    public HashMap<Integer, Gadget> getNotWorkingGadgets() {
        return notWorkingGadgets;
    }

    public void setNotWorkingGadgets(HashMap<Integer, Gadget> notWorkingGadgets) {
        this.notWorkingGadgets = notWorkingGadgets;
    }

    public void setSoledItems(HashMap<Integer, Gadget> soledItems) {
        this.soledItems = soledItems;
    }

    public int getSoledItemPrice() {
        return soledItemPrice;
    }

}
