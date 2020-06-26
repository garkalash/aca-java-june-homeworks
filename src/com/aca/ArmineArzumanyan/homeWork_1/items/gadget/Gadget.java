package com.aca.ArmineArzumanyan.homeWork_1.items.gadget;

import com.aca.ArmineArzumanyan.homeWork_1.items.Item;

public abstract class Gadget extends Item {
    private final int recDuration;
    private final GadgetType gadgetType;

    public Gadget(String name, int code, int count, int price, int recDuration, GadgetType gadgetType) {
        super(name, code, count, price);
        this.gadgetType = gadgetType;
        this.recDuration = recDuration;
    }
    public enum GadgetType {
        AUDIO,
        VIDEO,
        AUDIO_VIDEO   }

    public enum VideoQuality {
        HD,
        VGA
    }

    public int getRecDuration() {
        return recDuration;
    }

    public GadgetType getGadgetType() {
        return gadgetType;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Gadget gadget = (Gadget) o;
        return getCode() == gadget.getCode();
    }


}