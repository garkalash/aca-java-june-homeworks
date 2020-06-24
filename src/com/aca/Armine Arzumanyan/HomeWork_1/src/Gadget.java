import java.util.ArrayList;
import java.util.List;

public abstract class Gadget implements Item {
    public String name;
    public int code;
    public int price;
    public int recDuration;
    public boolean mp4;
    public boolean mp3;
    public boolean hd;
    public boolean vga;
    static List<Gadget> allItems = new ArrayList<>();
    static List<Gadget> soledGadgets = new ArrayList<>();

    public static void sailItem(Gadget item) {
        soledGadgets.add(item);
        allItems.remove(item);
    }

    public Gadget(int code) {
        this.code = code;
    }

    @Override
    public int changePrice(int newPrice) {
        price = newPrice;
        return price;
    }
    public static int sumPrice(List<Gadget> gadgetList) {
        int sum = 0;
        for (Gadget gadget : gadgetList) {
            sum = sum + gadget.price;
        }
        return sum;
    }


    static void printItemList(List<Gadget> gadgetList) {
        for (Gadget gadget : gadgetList) {
            System.out.println(gadget.name + ": " + gadget.code);
        }
    }

    public static Gadget getGadgetByCode(int code) {
        for (Gadget item : allItems) {
            if (item.code == code) {

                return item;
            }

        }
        return null;


    }
}