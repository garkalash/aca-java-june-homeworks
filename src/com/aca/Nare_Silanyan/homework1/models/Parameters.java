package com.aca.Nare_Silanyan.homework1.models;

import java.util.ArrayList;
import java.util.List;
import java.util.Arrays;


public class Parameters {

    public String name;
    public int count;
    public String []type;
    public String[] format;
    public   String memory;
    public int hour;
    public int price;


    public Parameters(String name, int count,String [] type, String [] format, String memory, int hour, int price) {
        this.name = name;
        this.count = count;
        this.type = type;
        this.memory = memory;
        this.hour = hour;
        this.price = price;
        this.format=format;

    }

    public Parameters(String name, String [] format){
        this.name = name;
        this.format = format;
    }






    public String [] getType() {
        return type;
    }

    public void setType(String [] type) {
        this.type = type;
    }

    public String getMemory() {
        return memory;
    }

    public void setMemory(String memory) {
        this.memory = memory;
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


    public String[] getFormat() {
        return format;
    }

    public void setFormat(String[] format) {
        this.format = format;
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

    @Override
    public String toString() {
        return "Parameters{" +
                "name='" + name + '\'' +
                ", count=" + count +
                ", type=" + Arrays.toString(type) +
                ", format=" + Arrays.toString(format) +
                ", memory='" + memory + '\'' +
                ", hour=" + hour +
                ", price=" + price +
                '}';
    }
}
