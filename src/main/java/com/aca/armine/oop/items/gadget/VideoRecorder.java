package com.aca.armine.oop.items.gadget;

import java.util.logging.Logger;

public interface VideoRecorder {
    VideoQuality getVideoQuality();

    default void playVideo(){
        Logger logger = Logger.getGlobal();
        logger.info("Press PlayVideoRecording");
    }


    enum VideoQuality {
        HD, VGA;
    }



}
