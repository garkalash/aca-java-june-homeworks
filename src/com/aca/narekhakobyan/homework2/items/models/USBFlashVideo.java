package com.aca.narekhakobyan.homework1.items.models;

import com.aca.narekhakobyan.homework1.items.concepts.Gadget;
import com.aca.narekhakobyan.homework1.items.functionality.Video;
import com.aca.narekhakobyan.homework1.items.functionality.format.FormatVideo;
import com.aca.narekhakobyan.homework1.items.functionality.quality.VideoQuality;

import java.io.BufferedWriter;
import java.io.FileWriter;
import java.io.IOException;
import java.util.Objects;

public class USBFlashVideo extends Gadget implements Video {
    private final FormatVideo videoFormat;
    private final VideoQuality videoQuality;
    private final String name = "USB flash";

    public USBFlashVideo(Integer price, Integer recDuration, FormatVideo videoFormat,
                                    VideoQuality videoQuality, Integer count) {
        super(price, recDuration, count);
        this.videoFormat = videoFormat;
        this.videoQuality = videoQuality;
    }

    public USBFlashVideo(String line) {
        super(line);
        String cvsSplitBy = ",";
        String[] product = line.split(cvsSplitBy);
        this.videoFormat = FormatVideo.valueOf(product[4]);
        this.videoQuality = VideoQuality.valueOf(product[5]);
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        if (!super.equals(o)) return false;
        USBFlashVideo that = (USBFlashVideo) o;
        return videoFormat == that.videoFormat &&
                videoQuality == that.videoQuality &&
                Objects.equals(name, that.name);
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
        String path = "C:\\Users\\hakob\\IdeaProjects\\homework1\\src\\com\\aca\\narekhakobyan\\homework1\\output\\trading.csv";
        String outputData = this.name +
                "\n\t\t" + "video " + this.videoFormat + ", " + this.videoQuality +
                "\n\t\t" + "no inside memory" +
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

    public String getName() {
        return name;
    }
}
