package com.aca.armineArzumanyan.homeWork_1.main;


import com.aca.armineArzumanyan.homeWork_1.items.gadget.*;
import com.aca.armineArzumanyan.homeWork_1.manager.GadgetStoreManager;

import java.util.Map;
import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        GadgetStoreManager manager = new GadgetStoreManager();

        Scanner scanner = new Scanner(System.in);

        PenVideoRecorder penVideoRecorder = new PenVideoRecorder("PenVideoRecorder", 3, 6500, 2);
        manager.getAllItems().put(101, penVideoRecorder);
        manager.getVideoGadgets().put(101, penVideoRecorder);
        PenAudioRecorder penAudioRecorder = new PenAudioRecorder("PenAudioRecorder", 3, 14000, 9, 8);
        manager.getAllItems().put(102, penAudioRecorder);
        manager.getAudioGadgets().put(102, penAudioRecorder);
        UsbVideoRecorder usbVideoRecorder = new UsbVideoRecorder("USBVideoRecorder", 3, 5000, 2);
        manager.getAllItems().put(103, usbVideoRecorder);
        manager.getVideoGadgets().put(103, usbVideoRecorder);
        UsbAudioRecorder usbAudioRecorder = new UsbAudioRecorder("USBAudioRecorder", 3, 11000, 9, 8);
        manager.getAllItems().put(104, usbAudioRecorder);
        manager.getAudioGadgets().put(104, usbAudioRecorder);
        Watch watch = new Watch("Watch", 3, 13000, 5, 8);
        manager.getAllItems().put(105, watch);
        manager.getAudioGadgets().put(105, watch);
        manager.getVideoGadgets().put(105, watch);


        while (true) {
            System.out.println("1: pass a list of items ");
            System.out.println("2: sell item");
            System.out.println("3: how much is sold in AMD?");
            System.out.println("4: how much he has in stock in AMD?");
            System.out.println("5: list of record items");
            System.out.println("6: list of video items ");
            System.out.println("7: change any price");
            System.out.println("Input number: ");
            int i = scanner.nextInt();

            if (i == 1) {
                System.out.println("list of all items: ");
                manager.repository.GetItemsList(manager.getAllItems());

            } else if (i == 2) {
                System.out.println("list of all items: ");
                manager.repository.GetItemsList(manager.getAllItems());
                System.out.println("Input Item's code which you want to sale");
                int c = scanner.nextInt();
                if (manager.getAllItems().containsKey(c)) {
                    manager.sellItem(manager.getAllItems().get(c));
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
                manager.repository.GetItemsList(manager.getAudioGadgets());
            } else if (i == 6) {
                System.out.println("list of Video recorders: ");
                manager.repository.GetItemsList(manager.getVideoGadgets());
            } else if (i == 7) {
                System.out.println("list of all items: ");
                manager.repository.GetItemsList(manager.getAllItems());
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
            }

        }
    }
}
