package com.aca.narekhakobyan.homework1.items.concepts;

import java.util.Objects;
import java.util.Scanner;

public abstract class RecordableGadgetWithMemory extends MemoryGadget {
    private final Integer recDuration;

    protected RecordableGadgetWithMemory(String name, Integer price, Integer memory, Integer recDuration, Integer count) {
        super(name, price, memory, count);

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
        RecordableGadgetWithMemory that = (RecordableGadgetWithMemory) o;
        return Objects.equals(recDuration, that.recDuration);
    }

    private boolean isCorrectRecDuration(Integer recDuration) {
        return recDuration > 0;
    }

    protected Integer getRecDuration() {
        return recDuration;
    }
}
