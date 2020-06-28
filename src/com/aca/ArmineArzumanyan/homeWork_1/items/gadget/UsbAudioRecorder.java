package com.aca.armineArzumanyan.homeWork_1.items.gadget;

public class UsbAudioRecorder extends MemoryGadget implements AudioRecorder{

    public UsbAudioRecorder(String name,  int count, int price, int recDuration,int rum) {
        super(name, count, price, recDuration, rum);
    }

    @Override
    public AudioType getAudioType() {
        return AudioType.MP3;
    }
}
