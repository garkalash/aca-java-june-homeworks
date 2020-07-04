package com.aca.arminearzumanyan.homeworks.items.gadget;

import java.util.logging.Logger;

public interface VideoRecorder {
    VideoQuality getVideoQuality();

    enum VideoQuality {
        HD, VGA;
    }



}
