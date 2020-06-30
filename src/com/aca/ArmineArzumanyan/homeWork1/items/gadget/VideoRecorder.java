package com.aca.arminearzumanyan.homeWork1.items.gadget;

public interface VideoRecorder {
    VideoQuality getVideoQuality();

    enum VideoQuality {
        HD, VGA;
    }

}
