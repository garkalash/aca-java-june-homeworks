package com.aca.naresilanyan.oopHomework.models;

import java.util.List;

public class PenVideoRecorder extends Gadget implements VideoDevice {

    public PenVideoRecorder(String name, int count, String[] type, List<String> format, int hour, int price) {
        super(name, count, type, format, hour, price);
    }
}
