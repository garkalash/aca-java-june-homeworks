package com.aca.arminearzumanyan.homeworks.items.gadget;

import com.aca.arminearzumanyan.homeworks.items.Item;

import java.util.logging.Logger;

public abstract class Gadget extends Item {
    private final int recDuration;
    Logger logger = Logger.getGlobal();

    public Gadget(String name, int price, int recDuration) {
        super(name, price);
        this.recDuration = recDuration;
    }

    public int getRecDuration() {
        return recDuration;
    }

   public abstract void turnOnGadget();
//    {
//        logger.info("Press PlayVideoRecording");
//    }

    @Override
    public String toString() {
        return (getCount() + ":  " + getName() + ":  [" + getRecDuration() + ": hours,   " + getPrice() + "AmD]");
    }

}