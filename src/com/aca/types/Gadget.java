package com.aca.types;

public abstract class Gadget {
    public static int id = 0;
    public static int allItemsCount = 0;

    public String getName() {
        return name;
    }

    private final String name;
    private final int duration;
    private int price;
    private int count;
    private int gadgetId;

    public Gadget(String name, int duration, int price, int count) {
        this.name = name;
        gadgetId = id;
        id++;
        this.duration = duration;
        this.price = price;
        this.count = count;
        allItemsCount += count;
    }

    public int getGadgetId() {
        return gadgetId;
    }

    public int getDuration() {
        return duration;
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
