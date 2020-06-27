package com.aca.gadgets;

import com.aca.types.AudioRecorder;
import com.aca.types.MemoryGadget;
import com.aca.types.VideoRecorder;

public class USBAudio extends MemoryGadget implements AudioRecorder {

    public USBAudio(int duration, int price, int count, int memoryInGB, String name) {
        super(duration, price, count, memoryInGB, name);
    }

    @Override
    public AudioQuality getAudioQuality() {
        return AudioQuality.WAV;
    }
}
