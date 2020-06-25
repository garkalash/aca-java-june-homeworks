package com.aca.vardanmanasaryan.homework1.management;

public class Videogadgets extends Spygadgets implements Videorecordinggadget {
protected final String typeofclass;

    public Videogadgets(int price, int quanity, String name, int recordinghours, String typeofrecording, String typeofclass) {
        super(price, quanity, name, recordinghours, typeofrecording);
        this.typeofclass = typeofclass;
    }

    @Override
    public void videorecord() {

    }
}
