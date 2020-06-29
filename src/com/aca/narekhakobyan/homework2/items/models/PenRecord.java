package com.aca.narekhakobyan.homework1.items.models;

import com.aca.narekhakobyan.homework1.items.concepts.MemoryGadget;
import com.aca.narekhakobyan.homework1.items.functionality.Voice;
import com.aca.narekhakobyan.homework1.items.functionality.format.FormatSound;

import java.io.BufferedWriter;
import java.io.File;
import java.io.FileWriter;
import java.io.IOException;
import java.util.Objects;

public class PenRecord extends MemoryGadget implements Voice {
    FormatSound soundFormat;
    public final String name = "Pen";
    PenColor penColor;

    public PenRecord(Integer price, Integer recDuration, Integer memory,
                                  FormatSound soundFormat, Integer count, PenColor penColor) {
        super(price, memory, recDuration, count);
        this.soundFormat = soundFormat;
        this.penColor = penColor;
    }

    public PenRecord(String line) {
        super(line);
        String cvsSplitBy = ",";
        String[] product = line.split(cvsSplitBy);
        this.soundFormat = FormatSound.valueOf(product[5]);
        this.penColor = PenColor.valueOf(product[6]);
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        if (!super.equals(o)) return false;
        PenRecord penRecord = (PenRecord) o;
        return soundFormat == penRecord.soundFormat &&
                Objects.equals(name, penRecord.name) &&
                penColor == penRecord.penColor;
    }

    @Override
    public int hashCode() {
        return Objects.hash(soundFormat);
    }

    @Override
    public void print() {
        String path = "C:\\Users\\hakob\\IdeaProjects\\homework1\\src\\com\\aca\\narekhakobyan\\homework1\\output\\trading.csv";

        String outputData = this.name +
                "\n\t\t" + "record " + this.soundFormat +
                "\n\t\t" + this.getMemory() + "GB memory" +
                "\n\t\t" + this.getRecDuration() + " hours recording" +
                "\n\t\tPen color is " + this.penColor.name() +
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

    @Override
    public FormatSound getVoiceFormat() {
        return soundFormat;
    }
}
