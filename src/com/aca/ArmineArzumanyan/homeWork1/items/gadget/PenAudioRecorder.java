package com.aca.arminearzumanyan.homeWork1.items.gadget;

public class PenAudioRecorder extends MemoryGadget implements AudioRecorder {

    public PenAudioRecorder(String name, int count, int price, int recDuration, int memoryInGB) {
        super(name, count, price, recDuration, memoryInGB);
    }

    @Override
    public AudioType getAudioType() {
        return AudioType.MP3;
    }
}
