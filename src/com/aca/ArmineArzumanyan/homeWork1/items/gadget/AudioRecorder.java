package com.aca.arminearzumanyan.homework1.items.gadget;

public interface AudioRecorder {
    AudioType getAudioType();
    enum AudioType {
        MP3, WAV;
    }


}
