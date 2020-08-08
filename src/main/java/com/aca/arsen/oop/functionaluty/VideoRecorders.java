package com.aca.arsen.oop.functionaluty;

public interface VideoRecorders {
    VideoQuality getVideoQuality();
    enum  VideoQuality{
        HD, VGA
    }
}
