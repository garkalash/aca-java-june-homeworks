package com.aca.arsen.oop.devices;

import com.aca.arsen.oop.functionaluty.*;

public class USBFlashVideoDeivce extends Gadget implements VideoRecorders {

    public USBFlashVideoDeivce(String name,int duration, int price, int count) {
        super(name,duration, price, count);
    }

    @Override
    public VideoQuality getVideoQuality() {
        return VideoQuality.VGA;
    }
}
