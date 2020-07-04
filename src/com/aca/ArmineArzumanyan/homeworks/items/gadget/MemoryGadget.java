package com.aca.arminearzumanyan.homeworks.items.gadget;


import java.util.logging.Logger;

public class MemoryGadget extends Gadget {
    private final int memoryInGB;


    public MemoryGadget(String name, int price, int recDuration, int memoryInGB) {
        super(name, price, recDuration);
        this.memoryInGB = memoryInGB;
    }

    public int getMemoryInGB() {
        return memoryInGB;
    }

    @Override
   public void turnOnGadget() {
        logger.info("Press PlayAudioRecording");
    }
}
