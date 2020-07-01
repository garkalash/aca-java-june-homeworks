package com.aca.items;

import com.aca.types.AudioRecorder;
import com.aca.types.MemoryGadget;
import com.aca.types.VideoRecorder;

public class Watch extends MemoryGadget implements AudioRecorder, VideoRecorder {
    public Watch(int duration, int price, int count, int memoryInGB) {
        super(duration, price, count, memoryInGB);
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
