package com.aca.items;

import com.aca.types.AudioRecorder;

public class RedPenAudioRecorder extends PenAudioRecorder {

    public RedPenAudioRecorder(int duration, int price, int count, int memoryInGB,String name) {
        super(duration, price, count, memoryInGB,name);
        this.color = "red";
    }
}
