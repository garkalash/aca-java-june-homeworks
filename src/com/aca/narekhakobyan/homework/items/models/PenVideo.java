package com.aca.narekhakobyan.homework.items.models;

import com.aca.narekhakobyan.homework.items.concepts.Gadget;
import com.aca.narekhakobyan.homework.items.functionality.Video;
import com.aca.narekhakobyan.homework.items.functionality.format.FormatSound;
import com.aca.narekhakobyan.homework.items.functionality.format.FormatVideo;
import com.aca.narekhakobyan.homework.items.functionality.quality.VideoQuality;

import java.io.BufferedReader;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.util.logging.FileHandler;
import java.util.logging.Logger;

public class PenVideo extends Gadget implements Video {
    private final FormatVideo formatVideo;
    private final VideoQuality videoQuality;
    private final String name = "Pen Video";

    public PenVideo(FormatVideo formatVideo, VideoQuality videoQuality, Integer recDuration, Integer price, Integer count) {
        super(recDuration,price,count);
        this.formatVideo = formatVideo;
        this.videoQuality = videoQuality;
    }

    public static PenVideo initFromFile() {
        final Path inputFilePath = Paths.get("src\\com\\aca\\narekhakobyan\\homework\\input\\PenVideoProducts.csv");
        final Logger logger = Logger.getLogger("Errors");
        FileHandler errorsLog = null;
        try {
            errorsLog = new FileHandler("src\\com\\aca\\narekhakobyan\\homework\\errors\\errors.log", true);


        try(BufferedReader bufferedReader = new BufferedReader(new FileReader(inputFilePath.toFile()))) {
            String row;
            boolean isFileEmpty = true;
            logger.addHandler(errorsLog);
            while ((row = bufferedReader.readLine()) != null) {
                isFileEmpty = false;
                String[] productDetails = row.split(",");

                if (productDetails.length == 5) {
                    PenVideo penVideo = new PenVideo(FormatVideo.valueOf(productDetails[3].trim()),
                                                        VideoQuality.valueOf(productDetails[4].trim()),
                                                        Integer.valueOf(productDetails[2].trim()),
                                                        Integer.valueOf(productDetails[1].trim()),
                                                        Integer.valueOf(productDetails[0].trim()));

                    return penVideo;
                } else {
                    logger.severe("Wrong parameters for Pen Video product");
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
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        if (!super.equals(o)) return false;
        PenVideo penVideo = (PenVideo) o;
        return formatVideo == penVideo.formatVideo &&
                videoQuality == penVideo.videoQuality;
    }

    @Override
    public FormatVideo getVideoFormat() {
        return this.formatVideo;
    }

    @Override
    public VideoQuality getVideoQuality() {
        return this.videoQuality;
    }

    @Override
    public String toString() {
        return this.name +
                "\n\t\t" + "video " + this.formatVideo + ", " + this.videoQuality +
                "\n\t\t" + "no inside memory" +
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

    public String getName() {
        return name;
    }
}
