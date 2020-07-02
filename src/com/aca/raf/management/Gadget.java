package com.aca.raf.management;

public abstract class Gadget {
    private final int duretion;
    private int price;
    private int count;

    public Gadget(int duretion, int price, int count){
        this.duretion = duretion;
        this.price = price;
        this.count = count;
    }

    public int getDuretion() {
        return duretion;
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
