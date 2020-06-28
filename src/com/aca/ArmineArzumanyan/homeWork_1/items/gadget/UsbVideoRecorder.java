package com.aca.armineArzumanyan.homeWork_1.items.gadget;

public class UsbVideoRecorder extends Gadget implements VideoRecorder {

    public UsbVideoRecorder(String name, int count,int price,  int recDuration) {
        super(name, count, price, recDuration);
    }

    @Override
    public VideoRecorder.VideoQuality getVideoQuality() {
        return VideoRecorder.VideoQuality.HD;
    }
}
