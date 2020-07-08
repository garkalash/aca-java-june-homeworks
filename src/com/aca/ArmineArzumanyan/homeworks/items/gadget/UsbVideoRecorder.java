package com.aca.arminearzumanyan.homeworks.items.gadget;

public class UsbVideoRecorder extends Gadget implements VideoRecorder {

    public UsbVideoRecorder(String name, int price, int recDuration) {
        super(name, price, recDuration);
    }




    @Override
    public VideoQuality getVideoQuality() {
        return VideoQuality.HD;
    }


}
