package com.aca.arminearzumanyan.homework1.items.gadget;

import com.aca.arminearzumanyan.homework1.items.Item;

public abstract class Gadget extends Item {
    private final int recDuration;

    public Gadget(String name, int count, int price, int recDuration) {
        super(name, count, price);
        this.recDuration = recDuration;
    }

    public int getRecDuration() {
        return recDuration;
    }

    @Override
    public String toString() {
        return (getCount() + "  " + getName() + ": ");
    }


}