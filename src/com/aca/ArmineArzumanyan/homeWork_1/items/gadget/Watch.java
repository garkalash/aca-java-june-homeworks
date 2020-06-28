package com.aca.armineArzumanyan.homeWork_1.items.gadget;


public class Watch extends MemoryGadget implements VideoRecorder, AudioRecorder {

    public Watch(String name,  int count, int price, int recDuration, int rum ) {
        super(name,count, price, recDuration, rum);


    }

    @Override
    public AudioType getAudioType() {
        return AudioType.MP3;
    }

    @Override
    public VideoRecorder.VideoQuality getVideoQuality() {
        return VideoRecorder.VideoQuality.HD;
    }
}
