package com.aca.raf.management;

public interface VideoRecorder {

    VideoQuality getVideoQuality();

    enum VideoQuality {
        HD,
        VGA;
    }
}
