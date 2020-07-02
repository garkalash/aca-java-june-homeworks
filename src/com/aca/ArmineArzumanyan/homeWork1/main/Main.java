package com.aca.arminearzumanyan.homework1.main;


import com.aca.arminearzumanyan.homework1.manager.GadgetStoreManager;

import java.io.File;
import java.util.InputMismatchException;
import java.util.Scanner;

public class Main {
    public static void main(String[] args) {

        GadgetStoreManager manager = new GadgetStoreManager();
        Scanner scanner = new Scanner(System.in);

        File fileOut = new File("D:\\java\\Product.CSV");
        File fileIn = new File("D:\\java\\trading.CSV");

        manager.takeProductFromFile(fileOut);

        for (int i = 0; i < 5; i++) {
            String[] gadgetProperty = manager.getProductPropertyLines().get(i).split(",");
            manager.createGadget(gadgetProperty);
        }

        while (true) {
            System.out.println("1: pass a list of items ");
            System.out.println("2: sell item");
            System.out.println("3: how much is sold in AMD?");
            System.out.println("4: how much he has in stock in AMD?");
            System.out.println("5: list of audio items");
            System.out.println("6: list of video items ");
            System.out.println("7: change any price");
            System.out.println("8: Turn on");
            System.out.println("9: list of broken items");
            System.out.println("10: Write trading details in file");
            System.out.println("Input number: ");

            int i = manager.getIntegerFromUser();

            if (i == 1) {
                System.out.println("list of all items: ");
                manager.getItemsList(manager.getAllItems());
            } else if (i == 2) {
                System.out.println("list of all items: ");
                manager.getItemsList(manager.getAllItems());
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
                int allItemsPrice = manager.sumPrice(manager.getAllItems());
                int allSoledItemsPrice = manager.sumPrice(manager.getSoledItems());
                System.out.println(allItemsPrice - allSoledItemsPrice);
            } else if (i == 5) {
                System.out.println("list of Audio recorders:");
                manager.getItemsList(manager.getAudioGadgetList(manager.getAllItems()));
            } else if (i == 6) {
                System.out.println("list of Video recorders: ");
                manager.getItemsList(manager.getVideoGadgetList(manager.getAllItems()));
            } else if (i == 7) {
                System.out.println("list of all items: ");
                manager.getItemsList(manager.getAllItems());
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
                System.out.println("Input Gadget's code which  you want turn on");
                int c = scanner.nextInt();
                if (manager.getAllItems().containsKey(c)) {
                    manager.turnOnGadget(manager.getAllItems().get(c));
                } else {
                    System.out.println("wrong input!!");
                    return;
                }
            } else if (i == 9) {
                manager.getItemsList(manager.getNotWorkingGadgets());
            } else if (i == 10) {
                manager.putTradingDetails(fileIn);
            }
        }

    }
}
