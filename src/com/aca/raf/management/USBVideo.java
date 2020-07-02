package com.aca.raf.management;

public class USBVideo extends Gadget implements VideoRecorder {
    public USBVideo(int duretion, int price, int count) {
        super(duretion, price, count);
    }

    @Override
    public VideoQuality getVideoQuality() {
        return VideoQuality.VGA;
    }
}
