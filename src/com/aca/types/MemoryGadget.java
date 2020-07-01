package com.aca.types;

import com.aca.types.Gadget;

public class MemoryGadget extends Gadget {
    private final int memoryInGB;

    public MemoryGadget(int duration, int price, int count, int memoryInGB) {
        super(duration, price, count);
        this.memoryInGB = memoryInGB;
    }

    public int getMemoryInGB() {
        return memoryInGB;
    }
}
