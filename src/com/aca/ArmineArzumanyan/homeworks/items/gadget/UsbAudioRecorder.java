package com.aca.arminearzumanyan.homeworks.items.gadget;

import java.util.logging.Logger;

public class UsbAudioRecorder extends MemoryGadget implements AudioRecorder {

    public UsbAudioRecorder(String name, int price, int recDuration, int memoryInGB) {
        super(name, price, recDuration, memoryInGB);
    }

    @Override
    public AudioType getAudioType() {
        return AudioType.MP3;
    }


}
