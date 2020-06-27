package com.aca.types;

public interface AudioRecorder {
    AudioQuality getAudioQuality();
    enum  AudioQuality{
        MP3, WAV;
    }
}
