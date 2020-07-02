package com.aca.raf.management;

public class PenVideoRecorder extends Gadget implements VideoRecorder{
    private String writingColor;

    public PenVideoRecorder(int duretion, int price, int count, String writingColor) {
        super(duretion, price, count);
        this.writingColor = writingColor;

    }

    public String getWritingColor() {
        return writingColor;
    }

    @Override
    public VideoQuality getVideoQuality() {
        return VideoQuality.VGA;
    }
}
