package com.aca.raf.management;

public class Watch extends MemoryGadget implements AudioRecorder, VideoRecorder {
    public Watch(int duretion, int price, int count, int memoryInGB) {
        super(duretion, price, count, memoryInGB);
    }

    @Override
    public AudioType getAudioType() {
        return AudioType.MP3;
    }

    @Override
    public VideoQuality getVideoQuality() {
        return VideoQuality.HD;
    }
}
