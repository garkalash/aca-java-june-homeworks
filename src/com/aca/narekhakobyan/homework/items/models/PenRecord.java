package com.aca.narekhakobyan.homework.items.models;

import com.aca.narekhakobyan.homework.items.concepts.MemoryGadget;
import com.aca.narekhakobyan.homework.items.functionality.Voice;
import com.aca.narekhakobyan.homework.items.functionality.format.FormatSound;

import java.io.*;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.util.Objects;
import java.util.logging.FileHandler;
import java.util.logging.Logger;

public class PenRecord extends MemoryGadget implements Voice {
    private final FormatSound formatSound;
    private final String name = "Pen Record";
    private final PenColor penColor;

    public PenRecord(FormatSound formatSound, Integer memory, Integer recDuration, Integer price, Integer count, PenColor penColor) {
        super(memory, recDuration, price, count);
        this.formatSound = formatSound;
        this.penColor = penColor;
    }

    public static PenRecord initFromFile() {
        final Path inputFilePath = Paths.get("src\\com\\aca\\narekhakobyan\\homework\\input\\PenRecordProducts.csv");
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

                if (productDetails.length == 6) {
                    PenRecord penRecord = new PenRecord(FormatSound.valueOf(productDetails[4].trim()),
                                                        Integer.valueOf(productDetails[3].trim()),
                                                        Integer.valueOf(productDetails[2].trim()),
                                                        Integer.valueOf(productDetails[1].trim()),
                                                        Integer.valueOf(productDetails[0].trim()),
                                                        PenColor.valueOf(productDetails[5].trim()));

                    return penRecord;
                } else {
                    logger.severe("Wrong parameters for Pen Record product");
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
        PenRecord penRecord = (PenRecord) o;
        return formatSound == penRecord.formatSound &&
                Objects.equals(name, penRecord.name) &&
                penColor == penRecord.penColor;
    }

    public enum PenColor {
        Red,
        Blue
    }

    @Override
    public String toString() {
        return this.name +
                "\n\t\t" + "record " + this.formatSound +
                "\n\t\t" + this.getMemory() + "GB memory" +
                "\n\t\t" + this.getRecDuration() + " hours recording" +
                "\n\t\tPen color is " + this.penColor.name() +
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

    @Override
    public FormatSound getVoiceFormat() {
        return formatSound;
    }
}
