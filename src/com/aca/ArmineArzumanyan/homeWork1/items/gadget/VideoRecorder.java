package com.aca.arminearzumanyan.homework1.items.gadget;

public interface VideoRecorder {
    VideoQuality getVideoQuality();

    enum VideoQuality {
        HD, VGA;
    }

}
