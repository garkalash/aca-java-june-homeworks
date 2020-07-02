package com.aca.arminearzumanyan.homework1.items.gadget;

public class PenVideoRecorder extends Gadget implements VideoRecorder, PenRecorder {


    public PenVideoRecorder(String name, int count, int price, int recDuration) {
        super(name, count, price, recDuration);
    }

    @Override
    public VideoQuality getVideoQuality() {
        return VideoQuality.VGA;
    }

    @Override
    public WritingColor getWritingColor() {
        return  WritingColor.RAD_BLUE;
    }


}
