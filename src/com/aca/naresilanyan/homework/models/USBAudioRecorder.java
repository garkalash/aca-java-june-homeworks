package com.aca.naresilanyan.homework.models;

import java.util.List;

public class USBAudioRecorder extends GadgetMemory implements AudioDevice {

    public USBAudioRecorder(String name, int count, String[] type, List<String> format, int hour, int price, String memory) {
        super(name, count, type, format, hour, price, memory);
    }
}
