package com.aca.arsen.oop.devices;

import com.aca.arsen.oop.functionaluty.*;

public class PenDevice extends MemoryGadget implements AudioRecorders {
    private final String penColor;

    public PenDevice(String name,int duration, int price, int count, int memorysize, String penColor) {
        super(name,duration, price, count, memorysize);
        this.penColor = penColor;
    }


    @Override
    public AudioQuality getAudioQuality() {
        return AudioQuality.MP3;
    }


    public String getPenColor() {
        return penColor;
    }
}
