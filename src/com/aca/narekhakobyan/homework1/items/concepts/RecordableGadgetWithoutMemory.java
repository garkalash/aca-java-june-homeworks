package com.aca.narekhakobyan.homework1.items.concepts;

import java.util.Objects;
import java.util.Scanner;

public abstract class RecordableGadgetWithoutMemory extends Gadget {
    protected final Integer recDuration;

    protected RecordableGadgetWithoutMemory(String name, Integer price, Integer recDuration, Integer count) {
        super(name, price, count);

        while (!isCorrectRecDuration(recDuration)) {
            System.out.println("Incorrect record duration. Please reenter.");
            Scanner in = new Scanner(System.in);
            recDuration = in.nextInt();
        }

        this.recDuration = recDuration;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        if (!super.equals(o)) return false;
        RecordableGadgetWithoutMemory that = (RecordableGadgetWithoutMemory) o;
        return Objects.equals(recDuration, that.recDuration);
    }

    private boolean isCorrectRecDuration(Integer recDuration) {
        return recDuration > 0;
    }

    protected Integer getRecDuration() {
        return recDuration;
    }
}
