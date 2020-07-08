package com.aca.arminearzumanyan.homeworks.items.gadget;


public class Watch extends MemoryGadget implements VideoRecorder, AudioRecorder {

    public Watch(String name, int price, int recDuration, int memoryInGB) {
        super(name, price, recDuration, memoryInGB);
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
