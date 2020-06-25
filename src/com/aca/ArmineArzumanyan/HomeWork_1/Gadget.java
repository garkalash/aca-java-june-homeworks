package com.aca.ArmineArzumanyan.HomeWork_1;

public abstract class Gadget extends Item {
    public int recDuration;
    public GadgetType gadgetType;

    public Gadget(String name, int code) {
        super(name, code);
    }
    public enum GadgetType {
        RECORD ("R"),
        VIDEO ("V"),
        RECORD_VIDEO("R&V");
        GadgetType(String CODE) {
        }
    }
}