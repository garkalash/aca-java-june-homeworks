package com.aca.naresilanyan.oopHomework.models;

import java.util.List;

public class PenAudioRecorder extends GadgetMemory implements AudioDevice{
    private List<String> colors;

    public PenAudioRecorder(String name, int count, String[] type, List<String> format, int hour, int price, String memory, List<String> colors) {
        super(name, count, type, format, hour, price, memory);
        this.colors = colors;
    }
}
