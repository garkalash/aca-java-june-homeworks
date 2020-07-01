package com.aca.items;

import com.aca.types.AudioRecorder;
import com.aca.types.MemoryGadget;

public class USBAudio extends MemoryGadget implements AudioRecorder {

    public USBAudio(int duration, int price, int count, int memoryInGB) {
        super(duration, price, count, memoryInGB);
    }

    @Override
    public AudioQuality getAudioQuality() {
        return AudioQuality.WAV;
    }
}
