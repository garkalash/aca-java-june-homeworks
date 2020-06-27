package com.aca.gadgets;

import com.aca.types.Gadget;
import com.aca.types.VideoRecorder;

public class USBVideo extends Gadget implements VideoRecorder {
    public USBVideo(int duration, int price, int count,String name) {
        super(name, duration, price, count);
    }

    @Override
    public VideoQuality getVideoQuality() {
        return VideoQuality.VGA;
    }
}
