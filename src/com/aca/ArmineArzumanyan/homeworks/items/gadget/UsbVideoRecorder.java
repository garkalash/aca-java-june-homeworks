package com.aca.arminearzumanyan.homeworks.items.gadget;

public class UsbVideoRecorder extends Gadget implements VideoRecorder {

    public UsbVideoRecorder(String name, int price, int recDuration) {
        super(name, price, recDuration);
    }

    @Override
    public void turnOnGadget() {
        logger.info("Press PlayVideoRecording");

    }

    @Override
    public VideoQuality getVideoQuality() {
        return VideoQuality.HD;
    }


}
