package com.aca.armine.oop.items.gadget;

import java.util.logging.Logger;

public interface AudioRecorder {
    AudioType getAudioType();

    default void playAudio(){
        Logger logger = Logger.getGlobal();
        logger.info("Press PlayAudioRecording");
    }

    enum AudioType {
        MP3, WAV;
    }


}



