package com.aca.narekhakobyan.homework1.items.models;

import com.aca.narekhakobyan.homework1.items.concepts.RecordableGadgetWithMemory;
import com.aca.narekhakobyan.homework1.items.functionality.Voice;
import com.aca.narekhakobyan.homework1.items.functionality.format.FormatSound;

public class GadgetVideoWithMemory extends RecordableGadgetWithMemory implements Voice {
    FormatSound soundFormat;

    public GadgetVideoWithMemory(String name, Integer price, Integer recDuration, Integer memory,
                                 FormatSound soundFormat, Integer count) {
        super(name, price, memory, recDuration, count);
        this.soundFormat = soundFormat;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        if (!super.equals(o)) return false;
        GadgetVideoWithMemory that = (GadgetVideoWithMemory) o;
        return soundFormat == that.soundFormat;
    }

    @Override
    public void print() {
        System.out.println(this.getName() +
                "\n\t\t" + "video " + this.soundFormat +
                "\n\t\t" + this.getMemory() + "GB memory" +
                "\n\t\t" + this.getRecDuration() + " hours recording" +
                "\n\t\t" + this.getPrice() + " AMD");
    }

    @Override
    public FormatSound getVoiceFormat() {
        return soundFormat;
    }
}
