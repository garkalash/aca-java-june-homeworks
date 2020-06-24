package com.aca.narekhakobyan.homework1.items.models;

import com.aca.narekhakobyan.homework1.items.concepts.RecordableGadgetWithoutMemory;
import com.aca.narekhakobyan.homework1.items.functionality.Video;
import com.aca.narekhakobyan.homework1.items.functionality.Voice;
import com.aca.narekhakobyan.homework1.items.functionality.format.FormatSound;
import com.aca.narekhakobyan.homework1.items.functionality.format.FormatVideo;
import com.aca.narekhakobyan.homework1.items.functionality.quality.VideoQuality;

public class GadgetRecordVideoWithoutMemory extends RecordableGadgetWithoutMemory implements Video, Voice {
    FormatSound soundFormat;
    FormatVideo videoFormat;
    VideoQuality videoQuality;

    public GadgetRecordVideoWithoutMemory(String name, Integer price,
                                          Integer recDuration, FormatSound soundFormat,
                                          FormatVideo videoFormat, VideoQuality videoQuality, Integer count) {
        super(name, price, recDuration, count);
        this.soundFormat = soundFormat;
        this.videoFormat = videoFormat;
        this.videoQuality = videoQuality;
    }

    @Override
    public void print() {
        System.out.println(this.getName() +
                "\n\t\t" + "records " + this.soundFormat + " video " + this.videoFormat + ", " + this.getVideoQuality() +
                "\n\t\t" + "no inside memory" +
                "\n\t\t" + this.getRecDuration() + " hours recording" +
                "\n\t\t" + this.getPrice() + " AMD");
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        if (!super.equals(o)) return false;
        GadgetRecordVideoWithoutMemory that = (GadgetRecordVideoWithoutMemory) o;
        return soundFormat == that.soundFormat &&
                videoFormat == that.videoFormat &&
                videoQuality == that.videoQuality;
    }

    @Override
    public FormatVideo getVideoFormat() {
        return videoFormat;
    }

    @Override
    public VideoQuality getVideoQuality() {
        return videoQuality;
    }

    @Override
    public FormatSound getVoiceFormat() {
        return soundFormat;
    }
}
