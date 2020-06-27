package com.aca.types;

public interface VideoRecorder {
    VideoQuality getVideoQuality();
    enum  VideoQuality{
        HD, VGA;
    }
}

