package com.aca.arminearzumanyan.homeworks.items.gadget;

public class PenVideoRecorder extends Gadget implements VideoRecorder {


    public PenVideoRecorder(String name, int price, int recDuration) {
        super(name, price, recDuration);
    }

    @Override
    public void turnOnGadget() {
        logger.info("Press PlayVideoRecording");
    }

    @Override
    public VideoQuality getVideoQuality() {
        return VideoQuality.VGA;
    }

}
