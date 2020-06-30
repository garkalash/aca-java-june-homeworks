package com.aca.arminearzumanyan.homeWork1.items.gadget;

public class PenVideoRecorder extends Gadget implements VideoRecorder {


    public PenVideoRecorder(String name, int count, int price, int recDuration) {
        super(name, count, price, recDuration);
    }

    @Override
    public VideoQuality getVideoQuality() {
        return VideoQuality.VGA;
    }
}
