package com.aca.arsen.oop.devices;

import com.aca.arsen.oop.functionaluty.*;

public class PenVideoDevice extends Gadget implements VideoRecorders {

    public PenVideoDevice(String name,int duration, int price, int count) {
        super(name,duration, price, count);
    }


    @Override
    public VideoQuality getVideoQuality() {
        return VideoQuality.VGA;
    }
}
