import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        Pen_1 pen_1 = new Pen_1(101);
        Gadget.allItems.add(pen_1);
        Pen_2 pen_2 = new Pen_2(102);
        Gadget.allItems.add(pen_2);
        USB_1 usb_1 = new USB_1(103);
        Gadget.allItems.add(usb_1);
        USB_2 usb_2 = new USB_2(104);
        Gadget.allItems.add(usb_2);
        Watch watch = new Watch(105);
        Gadget.allItems.add(watch);

        List<Gadget> videoGadgets = new ArrayList<>();
        List<Gadget> recordGadgets = new ArrayList<>();

        for (Gadget item : Gadget.allItems) {
            if (item.mp4) {
                videoGadgets.add(item);
            }
            if (item.mp3) {
                recordGadgets.add(item);
            }
        }
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
                Gadget.printItemList(Gadget.allItems);
            } else if (i == 2) {
                System.out.println("list of all items: ");
                Gadget.printItemList(Gadget.allItems);
                System.out.println("Input Gadget's code which you want to sale");
                int c = scanner.nextInt();
                if (Gadget.getGadgetByCode(c) != null) {
                    Gadget.sailItem(Gadget.getGadgetByCode(c));
                } else {
                    System.out.println("wrong input!!");
                    return;
                }
            } else if (i == 3) {
                int sum = Gadget.sumPrice(Gadget.soledGadgets);
                System.out.println(sum);
            } else if (i == 4) {
                int sum = Gadget.sumPrice(Gadget.allItems);
                System.out.println(sum);
            } else if (i == 5) {
                System.out.println("list of record items:");
                Gadget.printItemList(recordGadgets);
            } else if (i == 6) {
                System.out.println("list of video items: ");
                Gadget.printItemList(videoGadgets);
            } else if (i == 7) {
                System.out.println("list of all items: ");
                Gadget.printItemList(Gadget.allItems);
                System.out.println("Input Gadget's code which price you want to change");
                int c = scanner.nextInt();
                if (Gadget.getGadgetByCode(c) != null) {
                    System.out.println("old price is: " + Gadget.getGadgetByCode(c).price);
                    System.out.println("input new price:");
                    int newPrice = scanner.nextInt();
                    Gadget.getGadgetByCode(c).price = newPrice;
                } else {
                    System.out.println("wrong input!!");
                    return;
                }
            }

        }
    }
}
