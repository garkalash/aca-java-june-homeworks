package com.aca.ArmineArzumanyan.homeWork_1.Items.Gadget;

import com.aca.ArmineArzumanyan.homeWork_1.Items.Gadget.Gadget;

public class GadgetWithMemory extends Gadget {
   private final int rum;

    public GadgetWithMemory(String name, int code, int count, int price, int recDuration, GadgetType gadgetType, int rum ) {
        super(name, code,count, price, recDuration, gadgetType);
        this.rum = rum;
    }

    public int getRum() {
        return rum;
    }
}
