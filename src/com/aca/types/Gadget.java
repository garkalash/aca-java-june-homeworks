package com.aca.types;

public abstract class Gadget {
    public static int id = 0;
    public static int allItemsCount = 0;
    private final int duration;
    private int price;
    private int count;

    public Gadget(int duration, int price, int count) {
        this.id ++;
        this.duration = duration;
        this.price = price;
        this.count = count;
        allItemsCount += count;
    }

    public int getId() {
        return id;
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
