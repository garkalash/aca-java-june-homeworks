package com.aca.arsen.oop.devices;

import com.aca.arsen.oop.functionaluty.*;

public class USBFlashDevice extends MemoryGadget implements AudioRecorders {

    public USBFlashDevice(String name,int duration, int price, int count, int memorysize) {
        super(name,duration, price, count, memorysize);
    }


    @Override
    public AudioQuality getAudioQuality() {
        return AudioQuality.MP3;
    }
}
