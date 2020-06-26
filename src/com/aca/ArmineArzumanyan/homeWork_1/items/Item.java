package com.aca.ArmineArzumanyan.homeWork_1.items;

public abstract class Item {
    private String name;
    private final int code;
    private int price;
    private int count;

    public Item(String name, int code, int count, int price) {
        this.code = code;
        this.name = name;
        this.count = count;
        this.price = price;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public int getCode() {
        return code;
    }


    public int getPrice() {
        return price;
    }

    public void setPrice(int price) {
        this.price = price;
    }

    public int getCount() {
        return count;
    }

    public void setCount(int count) {
        this.count = count;
    }
}
