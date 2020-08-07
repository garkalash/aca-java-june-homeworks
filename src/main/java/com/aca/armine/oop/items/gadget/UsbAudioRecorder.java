package com.aca.armine.oop.items.gadget;

public class UsbAudioRecorder extends MemoryGadget implements AudioRecorder {

    public UsbAudioRecorder(String name, int price, int recDuration, int memoryInGB) {
        super(name, price, recDuration, memoryInGB);
    }

    @Override
    public AudioType getAudioType() {
        return AudioType.MP3;
    }




}
