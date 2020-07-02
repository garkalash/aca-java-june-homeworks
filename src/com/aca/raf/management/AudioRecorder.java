package com.aca.raf.management;

public interface AudioRecorder {

    AudioType getAudioType();

    enum AudioType{
        MP3,
        WAV;
    }


}
