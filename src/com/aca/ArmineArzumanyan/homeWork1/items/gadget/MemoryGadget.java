package com.aca.arminearzumanyan.homework1.items.gadget;


public class MemoryGadget extends Gadget {
    private final int memoryInGB;

    public MemoryGadget(String name, int count, int price, int recDuration, int memoryInGB) {
        super(name, count, price, recDuration);
        this.memoryInGB = memoryInGB;
    }


    public int getMemoryInGB() {
        return memoryInGB;
    }
}
