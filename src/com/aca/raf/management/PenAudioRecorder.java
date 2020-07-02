package com.aca.raf.management;

public class PenAudioRecorder extends MemoryGadget implements AudioRecorder{
    private String writingColor;
    public PenAudioRecorder(int duretion, int price, int count, int memoryInGB, String writingColor) {
        super(duretion, price, count, memoryInGB);
        this.writingColor = writingColor;
    }

    public String getWritingColor() {
        return writingColor;
    }

    @Override
    public AudioType getAudioType() {
        return AudioType.MP3;
    }


}
