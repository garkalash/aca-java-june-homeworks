package com.aca.narekhakobyan.homework.items.concepts;

import java.util.Objects;

public abstract class MemoryGadget extends Gadget {
    private final Integer memory;

    protected MemoryGadget(Integer memory, Integer recDuration, Integer price, Integer count) {
        super(recDuration,price,count);
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
