package com.aca.armine.oop.items.gadget;

public class PenVideoRecorder extends Gadget implements VideoRecorder {


    public PenVideoRecorder(String name, int price, int recDuration) {
        super(name, price, recDuration);
    }


    @Override
    public VideoQuality getVideoQuality() {
        return VideoQuality.VGA;
    }

}
