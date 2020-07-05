package com.aca.items;

public class BluePenAudioRecorder extends PenAudioRecorder {
    public BluePenAudioRecorder(int duration, int price, int count, int memoryInGB,String name) {
        super(duration, price, count, memoryInGB,name);
        this.color = "blue";
    }
}
