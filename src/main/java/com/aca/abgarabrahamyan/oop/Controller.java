package abgarabrahamyan.oop;

import java.util.Scanner;

public class Controller {
    static private double soldInAmd;
    static private double inStockInAmd;

    public double getSoldInAmd() {
        return soldInAmd;
    }

    public double getInStockInAmd() {
        return inStockInAmd;
    }

    void start() {
        // Menu
        System.out.println("1) pass a list of items with quantities in the beginning\n" +
                "2) sell item\n" +
                "3) anytime wants to check how much is sold in AMD\n" +
                "4) anytime wants to check how much he has in stock in AMD\n" +
                "5) get list of record items\n" +
                "6) get list of video items - all, by type\n" +
                "7) change any price\n" +
                "0) EXIT");
        // Input format
        Scanner scan = new Scanner(System.in);
        byte button = -1;
        while (button != 0) {
            System.out.println("##############################################################");
            button = scan.nextByte();
            switch(button) {
                case 1: // pass a list of items with quantities in the beginning
                    Gadget item;
                    System.out.println("1) Record Item\n 2orSmt.else) Video Item");

                    // Add Item In Record Items List
                    if (scan.nextByte() == 1) {
                        System.out.print("Name: ");   String name = scan.next();
                        System.out.print("Type: ");   String type = scan.next();
                        System.out.print("Memory in GBs: ");  Byte memory = scan.nextByte();
                        System.out.print("Charge time in hours: ");   Byte chargeTime = scan.nextByte();
                        System.out.print("Price in AMD: ");   double price = scan.nextDouble();
                        item = new RecordItem(name, type, memory, chargeTime, price);
                        Store.recordItems.add(item);
                    }
                    // Add Item In Video Items List
                    else {
                        System.out.print("Name: ");   String name = scan.next();
                        System.out.print("Type: ");   String type = scan.next();
                        System.out.print("Memory in GBs: ");  Byte memory = scan.nextByte();
                        System.out.print("Charge time in hours: ");   Byte chargeTime = scan.nextByte();
                        System.out.print("Price in AMD: ");   double price = scan.nextDouble();
                        item = new VideoItem(name, type, memory, chargeTime, price);
                        Store.videoItems.add(item);
                    }
                    //Store.items.add(item);
                    inStockInAmd += item.getPriceInAmd(); // add in stock
                    break;
                case 2: // sell item
                    System.out.println("1) Record Item\n 2orSmt.else) Video Item");
                    boolean isFound = false; // to check is the item has been found or not

                    // Look For In Record Items
                    if (scan.nextInt() == 1) {
                        String lookFor = scan.next();
                        for (Gadget i : Store.recordItems) {
                            if (i.getName().toLowerCase().equals(lookFor.toLowerCase())) {
                                soldInAmd += i.getPriceInAmd(); // add in sold
                                inStockInAmd -= i.getPriceInAmd(); // subtract from stock
                                Store.recordItems.remove(i); // remove item from the stock
                                isFound = true;
                                break;
                            }
                        }
                        System.out.println("The item is " + (isFound ? "sold." : "not found.")); // Message to user
                    }

                    // Look For In Video Items
                    else {
                        String lookFor = scan.next();
                        for (Gadget i : Store.videoItems) {
                            if (i.getName().toLowerCase().equals(lookFor.toLowerCase())) {
                                soldInAmd += i.getPriceInAmd(); // add in sold
                                inStockInAmd -= i.getPriceInAmd(); // subtract from stock
                                Store.videoItems.remove(i); // remove item from the stock
                                isFound = true;
                                break;
                            }
                        }
                        System.out.println("The item is " + (isFound ? "sold." : "not found.")); // Message to user
                    }
                    /*
                    for (Gadget i : Store.items) {
                        if (i.getName().equals(lookFor)) {
                            soldInAmd += i.getPriceInAmd(); // add in sold
                            inStockInAmd -= i.getPriceInAmd(); // subtract from stock
                            Store.items.remove(i); // remove item from the stock
                        }
                    }
                    */
                    break;
                case 3: // anytime wants to check how much is sold in AMD
                    System.out.println(getSoldInAmd());
                    break;
                case 4: // anytime wants to check how much he has in stock in AMD
                    System.out.println(getInStockInAmd());
                    break;
                case 5: // get list of record items
                    for (Gadget i : Store.recordItems) {
                        System.out.println("- " + i.getName() +
                                "\n\t" + i.getType() +
                                "\n\t" + i.getMemoryGb() + "GB memory" +
                                "\n\t" + i.getChargeTimeInHours() + " recording" +
                                "\n\t" + i.getPriceInAmd() + " AMD");
                    }
                    break;
                case 6: // get list of video items - all, by type
                    for (Gadget i : Store.videoItems) {
                        System.out.println("- " + i.getName() +
                                "\n\t" + i.getType() +
                                "\n\t" + i.getMemoryGb() + "GB memory" +
                                "\n\t" + i.getChargeTimeInHours() + " recording" +
                                "\n\t" + i.getPriceInAmd() + " AMD");
                    }
                    break;
                case 7: // change any price
                    System.out.println("1) Record Item\n 2orSmt.else) Video Item");
                    isFound = false; // to check is the item has been found or not

                    // Look For In Record Items
                    if (scan.nextInt() == 1) {
                        String lookFor = scan.next();
                        for (Gadget i : Store.recordItems) {
                            if (i.getName().toLowerCase().equals(lookFor.toLowerCase())) {
                                System.out.print("Set new price: ");
                                double prevPrise = i.getPriceInAmd(); // prise of the item before update
                                i.setPriceInAmd(scan.nextDouble());
                                double currPrise = i.getPriceInAmd(); // prise of the item after update
                                inStockInAmd += (currPrise - prevPrise); // updating items' prise that are left in stock
                                isFound = true;
                                break;
                            }
                        }
                        System.out.println("The item" + (isFound ? "'s price has been changed"
                                : " is not found.")); // Message to user
                    }
                    // Look For In Video Items
                    else {
                        String lookFor = scan.next();
                        for (Gadget i : Store.videoItems) {
                            if (i.getName().toLowerCase().equals(lookFor.toLowerCase())) {
                                System.out.print("Set new price: ");
                                double prevPrise = i.getPriceInAmd(); // prise of the item before update
                                i.setPriceInAmd(scan.nextDouble());
                                double currPrise = i.getPriceInAmd(); // prise of the item after update
                                inStockInAmd += (currPrise - prevPrise); // updating items' prise that are left in stock
                                isFound = true;
                                break;
                            }
                        }
                        System.out.println("The item" + (isFound ? "'s price has been changed"
                                : " is not found.")); // Message to user
                    }
                    break;
                case 0: // EXIT
                    scan.close();
                    System.out.println("The program has been turned off.");
                    System.exit(-1);
                    break;
                default:
                    break;
            }
        }
    }
}
