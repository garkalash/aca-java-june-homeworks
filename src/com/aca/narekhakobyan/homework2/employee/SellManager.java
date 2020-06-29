package com.aca.narekhakobyan.homework1.employee;

import com.aca.narekhakobyan.homework1.employee.functionality.Employee;
import com.aca.narekhakobyan.homework1.employee.functionality.Management;
import com.aca.narekhakobyan.homework1.items.concepts.*;
import com.aca.narekhakobyan.homework1.items.functionality.Video;
import com.aca.narekhakobyan.homework1.items.functionality.Voice;
import com.aca.narekhakobyan.homework1.items.models.*;
import javafx.util.Pair;

import java.io.BufferedReader;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;
import java.util.ArrayList;
import java.util.Random;
import java.util.Scanner;

public class SellManager implements Management, Employee {

    private ArrayList<Gadget> gadgets = new ArrayList<Gadget>();
    private ArrayList<Gadget> noneWorkingGadgets = new ArrayList<Gadget>();
    private int soldAMD = 0;
    private int stockAMD = 0;

    public SellManager(ArrayList<Gadget> gadgets) {
        for (Gadget gadget : gadgets) {
            this.addItem((Gadget)gadget);
        }
        calculateStockAMD();
    }

    private void calculateStockAMD() {
        for (Gadget gadget : this.gadgets) {
            this.stockAMD += gadget.getPrice() * gadget.getCount();
        }
    }

    @Override
    public void listOfItems() {
        String path = "C:\\Users\\hakob\\IdeaProjects\\homework1\\src\\com\\aca\\narekhakobyan\\homework1\\output\\trading.csv";
        FileWriter fileWriter = null;
        try {
            fileWriter = new FileWriter(path);
            fileWriter.write("");
            fileWriter.close();
        } catch (IOException e) {
            e.printStackTrace();
        }
        for (Gadget gadget : this.gadgets) {
            gadget.print();
        }
    }

    public SellManager(String path) {
        String csvFile = "C:\\Users\\hakob\\IdeaProjects\\homework1\\src\\com\\aca\\narekhakobyan\\homework1\\input\\product.csv";
        String line = "";

        try (BufferedReader br = new BufferedReader(new FileReader(csvFile))) {

            while ((line = br.readLine()) != null) {

                if (line.contains("PenVideo"))
                    gadgets.add(new PenVideo(line));
                if (line.contains("PenRecord"))
                    gadgets.add(new PenRecord(line));
                if (line.contains("USBFlashRecord"))
                    gadgets.add(new USBFlashRecord(line));
                if (line.contains("USBFlashVideo"))
                    gadgets.add(new USBFlashVideo(line));
                if (line.contains("Watch"))
                    gadgets.add(new Watch(line));
            }
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    public void listOfItemsVideoGadgets() {
        String path = "C:\\Users\\hakob\\IdeaProjects\\homework1\\src\\com\\aca\\narekhakobyan\\homework1\\output\\trading.csv";
        FileWriter fileWriter = null;
        try {
            fileWriter = new FileWriter(path);
            fileWriter.write("");
            fileWriter.close();
        } catch (IOException e) {
            e.printStackTrace();
        }
        for (Gadget gadget : gadgets) {
            if (gadget instanceof Video) {
                gadget.print();
            }
        }
    }

    public void listOfItemsRecordGadgets() {
        String path = "C:\\Users\\hakob\\IdeaProjects\\homework1\\src\\com\\aca\\narekhakobyan\\homework1\\output\\trading.csv";
        FileWriter fileWriter = null;
        try {
            fileWriter = new FileWriter(path);
            fileWriter.write("");
            fileWriter.close();
        } catch (IOException e) {
            e.printStackTrace();
        }
        for (Gadget gadget : gadgets) {
            if (gadget instanceof Voice) {
                gadget.print();
            }
        }
    }

    private boolean isCorrectAnswer(String answer) {
        return (isPositiveAnswer(answer) || isNegativeAnswer(answer)) ? true : false;
    }

    private boolean isPositiveAnswer(String answer) {
        return (answer.equals("y") || answer.equals("yes")) ? true : false;
    }

    private boolean isNegativeAnswer(String answer) {
        return (answer.equals("n") || answer.equals("no")) ? true : false;
    }

    @Override
    public void sellItem(Object gadgetObject, Integer count) {
        for (Gadget gadget : gadgets) {
            if (gadget.equals(gadgetObject)) {
                if (gadget.getCount() >= count) {
                    soldAMD += count * gadget.getPrice();
                    gadget.setCount(gadget.getCount() - count);
                    stockAMD -= gadget.getPrice() * count;
                    return;
                } else {
                    System.out.printf("Sorry. There are only %d items.\n", gadget.getCount());
                    System.out.println("Do you want that quantity?(y/n)/(yes/no)");
                    Scanner in = new Scanner(System.in);
                    String answer = in.nextLine();
                    answer = answer.toLowerCase();
                    answer = answer.replaceAll(" ","");

                    while (!isCorrectAnswer(answer)) {
                        System.out.println("Please enter correct answer.");
                        answer = in.nextLine();
                        answer = answer.toLowerCase();
                        answer = answer.replaceAll(" ","");
                    }

                    if (isPositiveAnswer(answer)) {
                        System.out.println("Thank you.");
                        soldAMD += gadget.getCount() * gadget.getPrice();
                        stockAMD -= gadget.getPrice() * gadget.getCount();
                        gadget.setCount(0);
                        return;
                    } else {
                        System.out.println("Sorry.");
                        return;
                    }
                }
            }
        }
        System.out.println("Sorry. There is not such kind of gadget.");
    }

    @Override
    public void sellItem(Object gadgetObject) {
        sellItem(gadgetObject, 1);
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
                while (price < 0) {
                    System.out.println("Wrong price. Please reenter.");
                    Scanner in = new Scanner(System.in);
                    price = in.nextInt();
                }
                stockAMD += gadget.getCount() * (price - gadget.getPrice());
                gadget.setPrice(price);
            }
        }
    }

    public void turnOn() {
        Random rand = new Random();
        boolean flag;
        int workCount = 0;
        int index;
        noneWorkingGadgets = (ArrayList<Gadget>) gadgets.clone();
        for (Gadget gadget : gadgets) {
            for (int i = 0; i < gadget.getCount(); ++i) {
                flag = rand.nextBoolean();
                if (flag) {
                    workCount++;
                }
            }
            if (workCount == gadget.getCount()) {
                noneWorkingGadgets.remove(gadget);
            } else {
                index = gadgets.indexOf(gadget);
                (noneWorkingGadgets.get(index)).setCount(gadget.getCount() - workCount);
                gadget.setCount(workCount);
            }
            workCount = 0;
        }
    }

    public void printListOfNonWorkingGadgets() {
        for (Gadget gadget : noneWorkingGadgets) {
            gadget.print();
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
