package com.aca.naresilanyan.homework.models;

import java.util.Arrays;
import java.util.List;

public class Gadget {

    protected String name;
    protected int count;
    protected String []type;
    protected List<String> format;
    protected int hour;
    protected int price;
//    protected  List<String> color;


    public Gadget(String name, int count, String[] type, List<String> format, int hour, int price) {
        this.name = name;
        this.count = count;
        this.type = type;
        this.format = format;
        this.hour = hour;
        this.price = price;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public int getCount() {
        return count;
    }

    public void setCount(int count) {
        this.count = count;
    }

    public String[] getType() {
        return type;
    }

    public void setType(String[] type) {
        this.type = type;
    }

    public List<String> getFormat() {
        return format;
    }

    public void setFormat(List<String> format) {
        this.format = format;
    }

    public int getHour() {
        return hour;
    }

    public void setHour(int hour) {
        this.hour = hour;
    }

    public int getPrice() {
        return price;
    }

    public void setPrice(int price) {
        this.price = price;
    }

    @Override
    public String toString() {
        return "Gadget{" +
                "name='" + name + '\'' +
                ", count=" + count +
                ", type=" + Arrays.toString(type) +
                ", format=" + format +
                ", hour=" + hour +
                ", price=" + price +
                '}';
    }
}
