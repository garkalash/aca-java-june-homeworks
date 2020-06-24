import java.util.List;

public abstract class Item {
    public String name;
    public int code;
    public int price;

    public Item(String name, int code) {
        this.code = code;
        this.name = name;
    }

    public int changePrice(int newPrice) {
        price = newPrice;
        return price;
    }

}
