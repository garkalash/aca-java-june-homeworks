package com.aca.arsen.oop.functionaluty;

public interface AudioRecorders {
    AudioQuality getAudioQuality();
    enum  AudioQuality {
        MP3, WAV
    }
}
