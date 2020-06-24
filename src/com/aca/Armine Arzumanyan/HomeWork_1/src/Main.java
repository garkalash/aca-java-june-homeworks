import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        Manager manager = new Manager();
        Scanner scanner = new Scanner(System.in);

        Pen_1 pen_1 = new Pen_1("Pen_1", 101);
        manager.allGadgets.add(pen_1);
        Pen_2 pen_2 = new Pen_2("Pen_2", 102);
        manager.allGadgets.add(pen_2);
        USB_1 usb_1 = new USB_1("USB_1", 103);
        manager.allGadgets.add(usb_1);
        USB_2 usb_2 = new USB_2("USB_2", 104);
        manager.allGadgets.add(usb_2);
        Watch watch = new Watch("Watch", 105);
        manager.allGadgets.add(watch);

        List<Gadget> videoGadgets = new ArrayList<>();
        List<Gadget> recordGadgets = new ArrayList<>();

        for (Gadget gadget : manager.allGadgets) {
            if (gadget.gadgetType == Gadget.GadgetType.VIDEO || gadget.gadgetType == Gadget.GadgetType.RECORD_VIDEO) {
                videoGadgets.add(gadget);
            }
            if (gadget.gadgetType == Gadget.GadgetType.RECORD || gadget.gadgetType == Gadget.GadgetType.RECORD_VIDEO) {
                recordGadgets.add(gadget);
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
                Manager.gadgetsRepository.printItemList(manager.allGadgets);
            } else if (i == 2) {
                System.out.println("list of all items: ");
                Manager.gadgetsRepository.printItemList(manager.allGadgets);
                System.out.println("Input Gadget's code which you want to sale");
                int c = scanner.nextInt();
                if (manager.getGadgetByCod(c) != null) {
                    manager.sailGadget(manager.getGadgetByCod(c));
                } else {
                    System.out.println("wrong input!!");
                    return;
                }
            } else if (i == 3) {
                int sum = Manager.gadgetsRepository.sumPrice(manager.soledGadgets);
                System.out.println(sum);
            } else if (i == 4) {
                int sum = Manager.gadgetsRepository.sumPrice(manager.allGadgets);
                System.out.println(sum);
            } else if (i == 5) {
                System.out.println("list of record items:");
                Manager.gadgetsRepository.printItemList(recordGadgets);
            } else if (i == 6) {
                System.out.println("list of video items: ");
                Manager.gadgetsRepository.printItemList(videoGadgets);
            } else if (i == 7) {
                System.out.println("list of all items: ");
                Manager.gadgetsRepository.printItemList(manager.allGadgets);
                System.out.println("Input Gadget's code which price you want to change");
                int c = scanner.nextInt();
                if (manager.getGadgetByCod(c) != null) {
                    System.out.println("old price is: " + manager.getGadgetByCod(c).price);
                    System.out.println("input new price:");
                    manager.getGadgetByCod(c).changePrice(scanner.nextInt());
                } else {
                    System.out.println("wrong input!!");
                    return;
                }
            }

        }
    }
}
