package com.aca.armineArzumanyan.homeWork_1.items.gadget;

public interface VideoRecorder {
    VideoQuality getVideoQuality();

    enum VideoQuality{
        HD, VGA;
    }

}
