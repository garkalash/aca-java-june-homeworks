package com.aca.arsen.oop.devices;

import com.aca.arsen.oop.functionaluty.*;

public class Watch extends MemoryGadget implements AudioRecorders, VideoRecorders {

    public Watch(String name,int duration, int price, int count, int memorysize) {
        super(name,duration, price, count, memorysize);
    }


    @Override
    public AudioQuality getAudioQuality() {
        return AudioQuality.MP3;
    }

    @Override
    public VideoQuality getVideoQuality() {
        return VideoQuality.HD;
    }
}
