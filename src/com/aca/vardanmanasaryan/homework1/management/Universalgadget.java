package com.aca.vardanmanasaryan.homework1.management;

public class Universalgadget extends Spygadgets implements Videorecordinggadget,Recordinggadget {
    protected final String typeofclass;
    protected  final String memory;

    public Universalgadget(int price, int quanity, String name, int recordinghours, String typeofrecording, String typeofclass, String memory) {
        super(price, quanity, name, recordinghours, typeofrecording);
        this.typeofclass = typeofclass;
        this.memory = memory;
    }

    @Override
    public void videorecord() {

    }

    @Override
    public void record() {

    }
}
