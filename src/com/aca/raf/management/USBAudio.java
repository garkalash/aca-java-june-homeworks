package com.aca.raf.management;

public class USBAudio extends MemoryGadget implements AudioRecorder {
    public USBAudio(int duretion, int price, int count, int memoryInGB) {
        super(duretion, price, count, memoryInGB);
    }

    @Override
    public AudioType getAudioType() {
        return AudioType.WAV;
    }
}
