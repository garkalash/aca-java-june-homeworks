package com.aca.narekhakobyan.homework1.items.models;

import com.aca.narekhakobyan.homework1.items.concepts.RecordableGadgetWithoutMemory;
import com.aca.narekhakobyan.homework1.items.functionality.Video;
import com.aca.narekhakobyan.homework1.items.functionality.format.FormatVideo;
import com.aca.narekhakobyan.homework1.items.functionality.quality.VideoQuality;

public class GadgetRecordWithoutMemory extends RecordableGadgetWithoutMemory implements Video {
    private final FormatVideo videoFormat;
    private final VideoQuality videoQuality;

    public GadgetRecordWithoutMemory(String name, Integer price, Integer recDuration, FormatVideo videoFormat,
                                     VideoQuality videoQuality, Integer count) {
        super(name, price, recDuration, count);
        this.videoFormat = videoFormat;
        this.videoQuality = videoQuality;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        if (!super.equals(o)) return false;
        GadgetRecordWithoutMemory that = (GadgetRecordWithoutMemory) o;
        return videoFormat == that.videoFormat &&
                videoQuality == that.videoQuality;
    }

    @Override
    public FormatVideo getVideoFormat() {
        return this.videoFormat;
    }

    @Override
    public VideoQuality getVideoQuality() {
        return this.videoQuality;
    }

    @Override
    public void print() {
        System.out.println(this.getName() +
                           "\n\t\t" + "video " + this.videoFormat + ", " + this.videoQuality +
                           "\n\t\t" + "no inside memory" +
                           "\n\t\t" + this.getRecDuration() + " hours recording" +
                           "\n\t\t" + this.getPrice() + " AMD");
    }
}
