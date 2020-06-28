package com.aca.armineArzumanyan.homeWork_1.items.gadget;

public class PenAudioRecorder extends MemoryGadget implements AudioRecorder {

    public PenAudioRecorder(String name, int count, int price, int recDuration, int rum) {
        super(name, count, price, recDuration, rum);


    }

    @Override
    public AudioType getAudioType() {
        return AudioType.MP3;
    }
}
