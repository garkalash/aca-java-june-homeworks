package com.aca.gadgets;

import com.aca.types.AudioRecorder;
import com.aca.types.MemoryGadget;

public class PenAudioRecorder extends MemoryGadget implements AudioRecorder {


    public PenAudioRecorder(int duration, int price, int count, int memoryInGB, String name) {
        super(duration, price, count, memoryInGB, name);
    }

    @Override
    public AudioQuality getAudioQuality() {
        return AudioQuality.MP3;
    }
}
