package com.aca.vardanmanasaryan.homework1.management;

public class Recordgadgets extends Spygadgets implements Recordinggadget {
    protected final String memory;

    public Recordgadgets(int price, int quanity, String name, int recordinghours, String typeofrecording, String memory) {
        super(price, quanity, name, recordinghours, typeofrecording);
        this.memory = memory;
    }



    @Override
    public void record() {

    }
}
