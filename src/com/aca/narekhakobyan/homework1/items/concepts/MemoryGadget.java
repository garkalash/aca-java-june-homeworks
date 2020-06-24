package com.aca.narekhakobyan.homework1.items.concepts;

import java.util.Objects;
import java.util.Scanner;

public abstract class MemoryGadget extends Gadget {
    private final Integer memory;

    protected MemoryGadget(String name, Integer price, Integer memory, Integer count) {
        super(name, price, count);

        while (!isCorrectMemory(memory)) {
            System.out.println("Incorrect memory. Please reenter.");
            Scanner in = new Scanner(System.in);
            memory = in.nextInt();
        }

        this.memory = memory;
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
