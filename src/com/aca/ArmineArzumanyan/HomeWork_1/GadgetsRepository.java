package com.aca.ArmineArzumanyan.HomeWork_1;

import java.util.ArrayList;
import java.util.List;

public class GadgetsRepository implements Repository<Gadget> {
    List<Gadget> allGadgets;

    public GadgetsRepository() {
        allGadgets = new ArrayList<>();
    }


    public int sumPrice(List<Gadget> gadgetList) {
        int sum = 0;
        for (Gadget gadget : gadgetList) {
            sum += gadget.price;
        }
        return sum;
    }

    public List<Gadget> getAll() {
        return allGadgets;
    }

    public void printItemList(List<Gadget> gadgetList) {
        for (Gadget gadget : gadgetList) {
            System.out.println(gadget.name + ": " + gadget.code);
        }


    }


}
