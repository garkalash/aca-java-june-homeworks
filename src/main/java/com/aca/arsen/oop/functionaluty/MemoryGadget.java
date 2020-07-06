package com.aca.arsen.oop.functionaluty;

public class MemoryGadget extends Gadget {
    private int memorysize;

    public MemoryGadget(String name,int duration, int price, int count, int memorysize) {
        super(name,duration, price, count);
        this.memorysize = memorysize;

    }

    public int getMemorysize() {
        return memorysize;
    }
}
