package com.aca.arminearzumanyan.homeworks.items.gadget;

import java.util.logging.Logger;

public interface AudioRecorder {
    AudioType getAudioType();


    enum AudioType {
        MP3, WAV;
    }


}



