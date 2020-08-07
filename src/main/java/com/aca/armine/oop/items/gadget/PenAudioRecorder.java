package com.aca.armine.oop.items.gadget;



public class PenAudioRecorder extends MemoryGadget implements AudioRecorder {

    public PenAudioRecorder(String name, int price, int recDuration, int memoryInGB) {
        super(name, price, recDuration, memoryInGB);
    }

    @Override
    public AudioType getAudioType() {
        return AudioType.MP3;
    }




    enum WritingColor {
        RED, BLUE
    }
}

