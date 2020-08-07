package com.aca.naresilanyan.homework.models;

import java.util.List;

public class USBVideoRecorder extends Gadget implements VideoDevice {

    public USBVideoRecorder(String name, int count, String[] type, List<String> format, int hour, int price) {
        super(name, count, type, format, hour, price);
    }
}
