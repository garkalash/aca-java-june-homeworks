package com.aca.arminearzumanyan.homeWork1.repository;

import com.aca.arminearzumanyan.homeWork1.items.gadget.Gadget;

import java.util.*;

public class GadgetsRepository implements ItemsRepository<Gadget> {
    private HashMap<Integer, Gadget> allGadgets;

    public GadgetsRepository() {
        allGadgets = new HashMap<>();
    }

    public HashMap<Integer, Gadget> getAll() {
        return allGadgets;
    }

    public void getItemsList(HashMap<Integer, Gadget> itemList) {

        for (Map.Entry list : itemList.entrySet()) {

            System.out.println(list.getValue() + " " + list.getKey());

        }
    }

}



