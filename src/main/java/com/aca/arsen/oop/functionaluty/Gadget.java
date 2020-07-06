package com.aca.arsen.oop.functionaluty;

public abstract class Gadget {
    private String name;
    private int duration;
    private int price;
    private int count;


    protected Gadget(String name,int duration, int price, int count) {
        this.name = name;
        this.duration = duration;
        this.price = price;
        this.count = count;
    }


    public String getName() {
        return name;
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

