package com.aca.naresilanyan.oopHomework.models;

import java.util.List;

public class Watch extends GadgetMemory implements VideoDevice,AudioDevice {

    public Watch(String name, int count, String[] type, List<String> format, int hour, int price, String memory) {
        super(name, count, type, format, hour, price, memory);
    }
}
