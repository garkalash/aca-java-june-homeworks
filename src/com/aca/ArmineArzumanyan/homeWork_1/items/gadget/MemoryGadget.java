package com.aca.armineArzumanyan.homeWork_1.items.gadget;


public class MemoryGadget extends Gadget {
    private final int rum;

    public MemoryGadget(String name, int count, int price, int recDuration, int rum) {
        super(name, count, price, recDuration);
        this.rum = rum;
    }


    public int getRum() {
        return rum;
    }
}
