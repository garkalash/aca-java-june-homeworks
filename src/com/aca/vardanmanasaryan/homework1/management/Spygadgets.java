package com.aca.vardanmanasaryan.homework1.management;

public abstract class Spygadgets implements SaleItem {
public int price;
public int quanity;
protected final String name;
protected final    int recordinghours;
protected final String typeofrecording;


    public Spygadgets(int price,int quanity, String name, int recordinghours,  String typeofrecording) {
        this.price = price;
        this.quanity = quanity;
        this.name = name;
        this.recordinghours = recordinghours;
        this.typeofrecording = typeofrecording;
    }

    public int getPrice() {
        return price;
    }

    public void setPrice(int price) {
        this.price = price;
    }

    @Override
    public void Sale() {

    }
}
