package com.aca.arminearzumanyan.homework1.items.gadget;

public class UsbAudioRecorder extends MemoryGadget implements AudioRecorder {

    public UsbAudioRecorder(String name, int count, int price, int recDuration, int memoryInGB) {
        super(name, count, price, recDuration, memoryInGB);
    }

    @Override
    public AudioType getAudioType() {
        return AudioType.MP3;
    }
}
