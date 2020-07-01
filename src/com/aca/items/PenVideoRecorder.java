package com.aca.items;

import com.aca.types.Gadget;
import com.aca.types.VideoRecorder;

public class PenVideoRecorder extends Gadget implements VideoRecorder {


    public PenVideoRecorder(int duration, int price, int count) {
        super( duration, price, count);
    }

    @Override
    public VideoQuality getVideoQuality() {
        return VideoQuality.VGA;
    }
}
