package com.aca.armineArzumanyan.homeWork_1.repository;

import com.aca.armineArzumanyan.homeWork_1.items.gadget.Gadget;

import java.util.*;

public class GadgetsRepository{ //implements ItemsRepository<Gadget> {
HashMap<Integer, Gadget> allGadgets;

    public GadgetsRepository() {
        allGadgets = new HashMap<>();
    }

    public HashMap<Integer,Gadget> getAll() {
        return allGadgets;
    }


    public void GetItemsList(HashMap<Integer, Gadget> itemList) {

        for (Map.Entry list : itemList.entrySet()) {

            System.out.println(list.getValue() + " "  + list.getKey() );

        }
    }



    }



