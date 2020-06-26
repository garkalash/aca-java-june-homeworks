package com.aca.ArmineArzumanyan.homeWork_1.Main;

import com.aca.ArmineArzumanyan.homeWork_1.Items.Gadget.*;
import com.aca.ArmineArzumanyan.homeWork_1.Manager.GadgetStoreManager;

import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        GadgetStoreManager manager = new GadgetStoreManager();

        Scanner scanner = new Scanner(System.in);

        PenVideoRecorder penVideoRecorder = new PenVideoRecorder("PenVideoRecorder", 101, 3, 6500, 2, Gadget.GadgetType.VIDEO, Gadget.VideoQuality.VGA);
        manager.allItems.add(penVideoRecorder);
        PenAudioRecorder penAudioRecorder = new PenAudioRecorder("PenAudioRecorder", 102, 3, 14000, 9, Gadget.GadgetType.AUDIO, 8);
        manager.allItems.add(penAudioRecorder);
        UsbVideoRecorder usbVideoRecorder = new UsbVideoRecorder("USBVideoRecorder", 103, 3, 5000, 2, Gadget.GadgetType.VIDEO, Gadget.VideoQuality.VGA);
        manager.allItems.add(usbVideoRecorder);
        UsbAudioRecorder usbAudioRecorder = new UsbAudioRecorder("USBAudioRecorder", 104, 3, 11000, 9, Gadget.GadgetType.AUDIO, 8);
        manager.allItems.add(usbAudioRecorder);
        Watch watch = new Watch("Watch", 105, 3, 13000, 5, Gadget.GadgetType.AUDIO_VIDEO, 8, Gadget.VideoQuality.HD);
        manager.allItems.add(watch);


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
                manager.repository.printItemList(manager.allItems);
            } else if (i == 2) {
                System.out.println("list of all items: ");
                manager.repository.printItemList(manager.allItems);
                System.out.println("Input Item's code which you want to sale");
                int c = scanner.nextInt();
                if (manager.repository.getItemByCod(c) != null) {
                    manager.sailItem(manager.repository.getItemByCod(c));
                } else {
                    System.out.println("wrong input!!");
                    return;
                }
            } else if (i == 3) {
                int allSoledItemsPrice = manager.soledItemPrice;
                System.out.println(allSoledItemsPrice);
            } else if (i == 4) {
                int allItemsPrice = manager.sumPrice(manager.allItems);
                int allSoledItemsPrice = manager.sumPrice(manager.soledItems);
                System.out.println(allItemsPrice - allSoledItemsPrice);
            } else if (i == 5) {
                System.out.println("list of Audio items:");
                manager.setAudioGadgets();
                manager.repository.printItemList(manager.audioGadgets);
            } else if (i == 6) {
                System.out.println("list of Video items: ");
                manager.setVideoGadgets();
                manager.repository.printItemList(manager.videoGadgets);
            } else if (i == 7) {
                System.out.println("list of all items: ");
                manager.repository.printItemList(manager.allItems);
                System.out.println("Input item's code which price you want to change");
                int c = scanner.nextInt();
                if (manager.repository.getItemByCod(c) != null) {
                    System.out.println("old price is: " + manager.repository.getItemByCod(c).getPrice());
                    System.out.println("input new price:");
                    manager.changePrice(manager.repository.getItemByCod(c), scanner.nextInt());
                } else {
                    System.out.println("wrong input!!");
                    return;
                }
            }

        }
    }
}
