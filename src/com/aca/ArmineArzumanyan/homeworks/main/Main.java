package com.aca.arminearzumanyan.homeworks.main;

import com.aca.arminearzumanyan.homeworks.items.gadget.Gadget;
import com.aca.arminearzumanyan.homeworks.manager.GadgetStoreManager;

import java.util.InputMismatchException;
import java.util.Map;
import java.util.Scanner;
import java.util.logging.Logger;

public class Main {

    public static void main(String[] args) {
        GadgetStoreManager manager = new GadgetStoreManager();
        Scanner scanner = new Scanner(System.in);

        while (true) {
            System.out.println("1: pass a list of items ");
            System.out.println("2: sell item");
            System.out.println("3: how much is sold in AMD?");
            System.out.println("4: how much he has in stock in AMD?");
            System.out.println("5: list of audio items");
            System.out.println("6: list of video items ");
            System.out.println("7: change any price");
            System.out.println("8: get list of broken items");
            System.out.println("Input number: ");

            int i = getIntegerFromUser();

            if (i == 1) {
                System.out.println("list of all items: ");
                getItemsList(manager.getAllItems());
            } else if (i == 2) {
                System.out.println("list of all items: ");
                getItemsList(manager.getAllItems());
                System.out.println("Input Item's code which you want to sale");
                int c = scanner.nextInt();
                if (manager.getAllItems().containsKey(c)) {
                    manager.sellItem(c);
                } else {
                    System.out.println("wrong input!!");
                    return;
                }
            } else if (i == 3) {
                int allSoledItemsPrice = manager.getSoledItemPrice();
                System.out.println(allSoledItemsPrice);
            } else if (i == 4) {
                int allItemsPrice = manager.sumPrice();
                int allSoledItemsPrice = manager.getSoledItemPrice();
                System.out.println(allItemsPrice - allSoledItemsPrice);
            } else if (i == 5) {
                System.out.println("list of Audio recorders:");
                getItemsList(manager.getAudioGadgets());
            } else if (i == 6) {
                System.out.println("list of Video recorders: ");
                getItemsList(manager.getVideoGadgets());
            } else if (i == 7) {
                System.out.println("list of all items: ");
                getItemsList(manager.getAllItems());
                System.out.println("Input item's code which price you want to change");
                int c = scanner.nextInt();
                if (manager.getAllItems().containsKey(c)) {
                    System.out.println("old price is: " + manager.getAllItems().get(c).getPrice());
                    System.out.println("input new price:");
                    manager.changePrice(manager.getAllItems().get(c), scanner.nextInt());
                } else {
                    System.out.println("wrong input!!");
                    return;
                }
            } else if (i == 8) {
                manager.getNotWorkingGadgets();
            }
        }

    }
    public static void getItemsList(Map<Integer, Gadget> allItems) {
        for (Integer i : allItems.keySet()) {
            System.out.println(allItems.get(i).toString() + ": {" + i + "}");
        }
    }

    public static int getIntegerFromUser() {
        Scanner scanner = new Scanner(System.in);
        Logger logger = Logger.getGlobal();
        try {
            return scanner.nextInt();
        } catch (InputMismatchException ex) {
            System.out.println("Wrong input");
            logger.severe("Wrong input. Exception occurred " + ex.getMessage());
            return 0;
        }
    }
}
