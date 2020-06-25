package com.aca.LarisaGabrielyan.Homework1;

import java.util.ArrayList;

public abstract class run implements Steps {
    private ArrayList<Product> product = new ArrayList<Product>();
    private int soldInAMD = 0;
    private int stockInAMD = 0;

    public int sold() {
        return soldInAMD;
    }

    public int stock(){
        return stockInAMD;
    }

    public void PriceChange(String name, int price) {
        for (Product i : this.product) {
            if (i.name.equals(name)) {
                i.price = price;
                return;
            }
        }
    }

}
