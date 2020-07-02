package com.aca.raf.management;

public abstract class MemoryGadget extends Gadget {
    private int memoryInGB;

    public MemoryGadget(int duretion, int price, int count, int memoryInGB){
        super(duretion, price, count);
        this.memoryInGB = memoryInGB;
    }

    public int getMemoryInGB() {
        return memoryInGB;
    }
}
