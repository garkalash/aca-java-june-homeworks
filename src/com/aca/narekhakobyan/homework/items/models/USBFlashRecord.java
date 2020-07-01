package com.aca.narekhakobyan.homework.items.models;

import com.aca.narekhakobyan.homework.items.concepts.MemoryGadget;
import com.aca.narekhakobyan.homework.items.functionality.Voice;
import com.aca.narekhakobyan.homework.items.functionality.format.FormatSound;

import java.io.BufferedReader;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.util.Objects;
import java.util.logging.FileHandler;
import java.util.logging.Logger;

public class USBFlashRecord extends MemoryGadget implements Voice {
    private final FormatSound formatSound;
    private final String name = "USB flash record";

    public USBFlashRecord(FormatSound formatSound, Integer memory, Integer recDuration, Integer price, Integer count) {
        super(memory, recDuration, price, count);
        this.formatSound = formatSound;
    }

    public static USBFlashRecord initFromFile() {
        final Path inputFilePath = Paths.get("src\\com\\aca\\narekhakobyan\\homework\\input\\USBFlashRecordProducts.csv");
        final Logger logger = Logger.getLogger("Errors");
        FileHandler errorsLog = null;
        try {
            errorsLog = new FileHandler("src\\com\\aca\\narekhakobyan\\homework\\errors\\errors.log", true);

        try (BufferedReader bufferedReader = new BufferedReader(new FileReader(inputFilePath.toFile()))) {
            String row;
            boolean isFileEmpty = true;
            logger.addHandler(errorsLog);
            while ((row = bufferedReader.readLine()) != null) {
                isFileEmpty = false;
                String[] productDetails = row.split(",");

                if (productDetails.length == 5) {
                    USBFlashRecord usbFlashRecord = new USBFlashRecord(FormatSound.valueOf(productDetails[4].trim()),
                            Integer.valueOf(productDetails[3].trim()),
                            Integer.valueOf(productDetails[2].trim()),
                            Integer.valueOf(productDetails[1].trim()),
                            Integer.valueOf(productDetails[0].trim()));

                    return usbFlashRecord;
                } else {
                    logger.severe("Wrong parameters for USB Flash Record product");
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
        USBFlashRecord that = (USBFlashRecord) o;
        return formatSound == that.formatSound &&
                Objects.equals(name, that.name);
    }

    @Override
    public String toString() {
        return this.name +
                "\n\t\t" + "record " + this.formatSound +
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
    public FormatSound getVoiceFormat() {
        return formatSound;
    }

    public String getName() {
        return name;
    }
}
