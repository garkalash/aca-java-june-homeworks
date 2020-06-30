package com.aca.arminearzumanyan.homeWork1.items.gadget;

public class UsbVideoRecorder extends Gadget implements VideoRecorder {

    public UsbVideoRecorder(String name, int count, int price, int recDuration) {
        super(name, count, price, recDuration);
    }

    @Override
    public VideoQuality getVideoQuality() {
        return VideoQuality.HD;
    }
}
