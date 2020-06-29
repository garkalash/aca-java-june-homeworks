package com.aca.narekhakobyan.homework1.items.concepts;

import java.util.Objects;
import java.util.Scanner;

public abstract class MemoryGadget extends Gadget {
    private final Integer memory;

    protected MemoryGadget(Integer price, Integer memory, Integer recDuration,Integer count) {
        super(price, recDuration, count);

        while (!isCorrectMemory(memory)) {
            System.out.println("Incorrect memory. Please reenter.");
            Scanner in = new Scanner(System.in);
            memory = in.nextInt();
        }

        this.memory = memory;
    }

    protected MemoryGadget(String line) {
        super(line);
        String cvsSplitBy = ",";
        String[] product = line.split(cvsSplitBy);

        while (!isCorrectMemory(Integer.valueOf(product[4]))) {
            System.out.println("Incorrect memory. Please reenter.");
            Scanner in = new Scanner(System.in);
            product[4] = in.next();
        }

        this.memory = Integer.valueOf(product[4]);
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        if (!super.equals(o)) return false;
        MemoryGadget that = (MemoryGadget) o;
        return Objects.equals(memory, that.memory);
    }

    private boolean isCorrectMemory(Integer memory) {
        return memory > 0;
    }

    protected Integer getMemory() {
        return memory;
    }
}
