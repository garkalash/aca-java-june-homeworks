package com.aca.vardanmanasaryan.homework1.management;

public class Cashbox implements SaleItem {
    protected int cash;

    public Cashbox(int cash) {
        this.cash = cash;
    }

    @Override
    public void Sale() {
    }
}
