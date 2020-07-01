package com.aca.narekhakobyan.homework.items.models;

import com.aca.narekhakobyan.homework.items.concepts.MemoryGadget;
import com.aca.narekhakobyan.homework.items.functionality.Video;
import com.aca.narekhakobyan.homework.items.functionality.Voice;
import com.aca.narekhakobyan.homework.items.functionality.format.FormatSound;
import com.aca.narekhakobyan.homework.items.functionality.format.FormatVideo;
import com.aca.narekhakobyan.homework.items.functionality.quality.VideoQuality;

import java.io.BufferedReader;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.util.Objects;
import java.util.logging.FileHandler;
import java.util.logging.Logger;

public class Watch extends MemoryGadget implements Video, Voice {
    private final String name = "Watch";
    private final FormatSound formatSound;
    private final FormatVideo formatVideo;
    private final VideoQuality videoQuality;

    public Watch(FormatSound formatSound, FormatVideo formatVideo, VideoQuality videoQuality, Integer memory,
                 Integer recDuration, Integer price, Integer count) {
        super(memory, recDuration, price, count);
        this.formatSound = formatSound;
        this.formatVideo = formatVideo;
        this.videoQuality = videoQuality;
    }

    public static Watch initFromFile() {
        final Path inputFilePath = Paths.get("src\\com\\aca\\narekhakobyan\\homework\\input\\WatchProducts.csv");
        final Logger logger = Logger.getLogger("Errors");
        FileHandler errorsLog = null;
        try {
            errorsLog = new FileHandler("src\\com\\aca\\narekhakobyan\\homework\\errors\\errors.log", true);

        logger.addHandler(errorsLog);
        try(BufferedReader bufferedReader = new BufferedReader(new FileReader(inputFilePath.toFile()))) {
            String row;
            boolean isFileEmpty = true;

            while ((row = bufferedReader.readLine()) != null) {
                isFileEmpty = false;
                String[] productDetails = row.split(",");

                    if (productDetails.length == 7) {
                    Watch watch = new Watch(FormatSound.valueOf(productDetails[4].trim()),
                            FormatVideo.valueOf(productDetails[5]),
                            VideoQuality.valueOf(productDetails[6]),
                            Integer.valueOf(productDetails[3].trim()),
                            Integer.valueOf(productDetails[0].trim()),
                            Integer.valueOf(productDetails[1].trim()),
                            Integer.valueOf(productDetails[2].trim()));

                    return watch;
                } else {
                    logger.severe("Wrong parameters for Watch product ");
                    return null;
                }
            }
            if (isFileEmpty) {
                logger.severe("Input file is empty");
                return null;
            }
        } catch (IOException e) {
            logger.severe("Input file of Pen Record not found");
            return null;
        }
        } catch (IOException e) {
            e.printStackTrace();
        } finally {
            errorsLog.close();
        }

        return null;
    }

    @Override
    public String toString() {
        return this.name +
                "\n\t\t" + "records " + this.formatSound + " video " + this.formatVideo + ", " + this.getVideoQuality() +
                "\n\t\t" + this.getMemory() + "GB memory" +
                "\n\t\t" + this.getRecDuration() + " hours recording" +
                "\n\t\t" + this.getPrice() + " AMD" +
                "\n\t\tIn stock " + this.getCount() + "\n";
    }

    @Override
    public void print(String path) {
        try {
            FileWriter fileWriter = new FileWriter(path, true);
            fileWriter.write(this.toString());
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
                formatSound == watch.formatSound &&
                formatVideo == watch.formatVideo &&
                videoQuality == watch.videoQuality;
    }

    @Override
    public FormatVideo getVideoFormat() {
        return formatVideo;
    }

    @Override
    public VideoQuality getVideoQuality() {
        return videoQuality;
    }

    @Override
    public FormatSound getVoiceFormat() {
        return formatSound;
    }

    public String getName() {
        return name;
    }
}
