package com.aca.arminearzumanyan.homework1.items.gadget;

public class PenAudioRecorder extends MemoryGadget implements AudioRecorder, PenRecorder {

    public PenAudioRecorder(String name, int count, int price, int recDuration, int memoryInGB) {
        super(name, count, price, recDuration, memoryInGB);
    }

    @Override
    public AudioType getAudioType() {
        return AudioType.MP3;
    }

    @Override
    public WritingColor getWritingColor() {
        return WritingColor.RAD_BLUE;
    }
}
