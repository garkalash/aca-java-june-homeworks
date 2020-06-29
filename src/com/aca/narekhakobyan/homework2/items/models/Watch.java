package com.aca.narekhakobyan.homework1.items.models;

import com.aca.narekhakobyan.homework1.items.concepts.MemoryGadget;
import com.aca.narekhakobyan.homework1.items.functionality.Video;
import com.aca.narekhakobyan.homework1.items.functionality.Voice;
import com.aca.narekhakobyan.homework1.items.functionality.format.FormatSound;
import com.aca.narekhakobyan.homework1.items.functionality.format.FormatVideo;
import com.aca.narekhakobyan.homework1.items.functionality.quality.VideoQuality;
import com.sun.media.jfxmedia.control.VideoFormat;

import java.io.BufferedWriter;
import java.io.FileWriter;
import java.io.IOException;
import java.util.Objects;

public class Watch extends MemoryGadget implements Video, Voice {
    private final String name = "Watch";
    FormatSound soundFormat;
    FormatVideo videoFormat;
    VideoQuality videoQuality;

    public Watch(Integer price, Integer memory, Integer recDuration, FormatSound soundFormat,
                 FormatVideo videoFormat, VideoQuality videoQuality, Integer count) {
        super(price, memory, recDuration, count);
        this.soundFormat = soundFormat;
        this.videoFormat = videoFormat;
        this.videoQuality = videoQuality;
    }

    public Watch(String line) {
        super(line);
        String cvsSplitBy = ",";
        String[] product = line.split(cvsSplitBy);
        this.soundFormat = FormatSound.valueOf(product[5]);
        this.videoFormat = FormatVideo.valueOf(product[6]);
        this.videoQuality = VideoQuality.valueOf(product[7]);
    }

    @Override
    public void print() {
        String path = "C:\\Users\\hakob\\IdeaProjects\\homework1\\src\\com\\aca\\narekhakobyan\\homework1\\output\\trading.csv";
        String outputData = this.name +
                "\n\t\t" + "records " + this.soundFormat + " video " + this.videoFormat + ", " + this.getVideoQuality() +
                "\n\t\t" + this.getMemory() + "GB memory" +
                "\n\t\t" + this.getRecDuration() + " hours recording" +
                "\n\t\t" + this.getPrice() + " AMD\n";
        try {
            FileWriter fileWriter = new FileWriter(path, true);
            fileWriter.write(outputData);
            fileWriter.close();
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        if (!super.equals(o)) return false;
        Watch watch = (Watch) o;
        return Objects.equals(name, watch.name) &&
                soundFormat == watch.soundFormat &&
                videoFormat == watch.videoFormat &&
                videoQuality == watch.videoQuality;
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

    public String getName() {
        return name;
    }
}
