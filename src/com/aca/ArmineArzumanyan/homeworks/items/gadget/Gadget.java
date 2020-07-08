package com.aca.arminearzumanyan.homeworks.items.gadget;

import com.aca.arminearzumanyan.homeworks.items.Item;


public abstract class Gadget extends Item {
    private final int recDuration;

    public Gadget(String name, int price, int recDuration) {
        super(name, price);
        this.recDuration = recDuration;
    }

    public int getRecDuration() {
        return recDuration;
    }

    @Override
    public String toString() {
        return getCount() + ":  " + getName() + ":  [" + getRecDuration() + ": hours,   " + getPrice() + "AmD]";
    }

    public static void turnOnGadget(Gadget gadget){
     if(gadget instanceof AudioRecorder){
         ((AudioRecorder) gadget).playAudio();
     }
     if (gadget instanceof VideoRecorder){
         ((VideoRecorder) gadget).playVideo();
     }
    }

}