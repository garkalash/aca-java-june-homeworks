package com.aca.narekhakobyan.homework1.items.models;

import com.aca.narekhakobyan.homework1.items.concepts.MemoryGadget;
import com.aca.narekhakobyan.homework1.items.functionality.Voice;
import com.aca.narekhakobyan.homework1.items.functionality.format.FormatSound;

import java.io.BufferedWriter;
import java.io.FileWriter;
import java.io.IOException;
import java.util.Objects;

public class USBFlashRecord extends MemoryGadget implements Voice {
    FormatSound soundFormat;
    private final String name = "USB flash";

    public USBFlashRecord(Integer price, Integer recDuration, Integer memory,
                     FormatSound soundFormat, Integer count) {
        super(price, memory, recDuration, count);
        this.soundFormat = soundFormat;
    }

    public USBFlashRecord(String line) {
        super(line);
        String cvsSplitBy = ",";
        String[] product = line.split(cvsSplitBy);
        this.soundFormat = FormatSound.valueOf(product[5]);
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        if (!super.equals(o)) return false;
        USBFlashRecord that = (USBFlashRecord) o;
        return soundFormat == that.soundFormat &&
                Objects.equals(name, that.name);
    }

    @Override
    public void print() {
        String path = "C:\\Users\\hakob\\IdeaProjects\\homework1\\src\\com\\aca\\narekhakobyan\\homework1\\output\\trading.csv";
        String outputData = this.name +
                "\n\t\t" + "record " + this.soundFormat +
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
    public FormatSound getVoiceFormat() {
        return soundFormat;
    }

    public String getName() {
        return name;
    }
}
