package com.aca.naresilanyan.oopHomework.models;

import java.util.List;

public class GadgetMemory extends Gadget {
    protected String memory;

    public GadgetMemory(String name, int count, String[] type, List<String> format, int hour, int price, String memory) {
        super(name, count, type, format, hour, price);
        this.memory = memory;
    }
}
