package items.models;

import items.concepts.Gadget;
import items.functionality.Video;
import items.functionality.quality.VideoQuality;

import java.io.BufferedReader;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.util.ArrayList;
import java.util.List;
import java.util.Objects;
import java.util.Random;
import java.util.logging.FileHandler;
import java.util.logging.Logger;

public class USBFlashVideo extends Gadget implements Video {
    private final String formatVideo = "MP4";
    private final VideoQuality videoQuality;
    private final String name = "USB flash video";

    public USBFlashVideo(VideoQuality videoQuality, Integer recDuration, Integer price, Integer count) {
        super(recDuration, price, count);
        this.videoQuality = videoQuality;
    }

    public static List<USBFlashVideo> initFromFile() {
        final Path inputFilePath = Paths.get("resources\\input\\USBFlashVideoProducts.csv");
        final Logger logger = Logger.getLogger("Errors");
        FileHandler errorsLog = null;
        try {
            errorsLog = new FileHandler("resources\\errors\\errors.log", true);

        try (BufferedReader bufferedReader = new BufferedReader(new FileReader(inputFilePath.toFile()))) {
            String row;
            boolean isFileEmpty = true;
            logger.addHandler(errorsLog);
            ArrayList<USBFlashVideo> usbFlashVideos = new ArrayList<>();
            while ((row = bufferedReader.readLine()) != null) {
                isFileEmpty = false;
                String[] productDetails = row.split(",");

                if (productDetails.length == 4) {
                    usbFlashVideos.add(new USBFlashVideo(VideoQuality.valueOf(productDetails[3].trim()),
                            Integer.valueOf(productDetails[0].trim()),
                            Integer.valueOf(productDetails[1].trim()),
                            Integer.valueOf(productDetails[2].trim())));
                } else {
                    logger.severe("Wrong parameters for USB Flash Video product");
                    return null;
                }
            }

            if (isFileEmpty) {
                logger.severe("Input file is empty");
                return null;
            }

            return usbFlashVideos;
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
        USBFlashVideo that = (USBFlashVideo) o;
        return formatVideo == that.formatVideo &&
                videoQuality == that.videoQuality &&
                Objects.equals(name, that.name);
    }

    @Override
    public boolean playVideo() {
        Random rand = new Random();
        return rand.nextBoolean();
    }

    @Override
    public String getVideoFormat() {
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

    @Override
    public boolean turnOn() {
        return this.playVideo();
    }

    public String getName() {
        return name;
    }
}
