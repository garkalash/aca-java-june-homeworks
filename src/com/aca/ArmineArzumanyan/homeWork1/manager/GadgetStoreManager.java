package com.aca.arminearzumanyan.homework1.manager;


import com.aca.arminearzumanyan.homework1.items.gadget.Gadget;
import com.aca.arminearzumanyan.homework1.repository.GadgetsRepository;

import java.util.HashMap;
import java.util.Map;

public class GadgetStoreManager implements Manager<Gadget> {

    public GadgetsRepository repository = new GadgetsRepository();
    private HashMap<Integer, Gadget> allItems = repository.getAll();
    private HashMap<Integer, Gadget> soledItems = new HashMap<>();
    private HashMap<Integer, Gadget> videoGadgets = new HashMap<>();
    private HashMap<Integer, Gadget> audioGadgets = new HashMap<>();
    private int soledItemPrice = 0;

    public void changePrice(Gadget gadget, int newPrice) {
        gadget.setPrice(newPrice);
    }


    public void sellItem(Gadget gadget) {
        for (Map.Entry list : allItems.entrySet()) {
            if (allItems.get(list.getKey()).equals(gadget)) {
                gadget.setCount(gadget.getCount() - 1);

                break;
            }
        }
        soledItemPrice += gadget.getPrice();
    }


    public int sumPrice(HashMap<Integer, Gadget> gadgetList) {
        int sum = 0;
        for (Map.Entry gadget : gadgetList.entrySet()) {

            sum += gadgetList.get(gadget.getKey()).getPrice() * gadgetList.get(gadget.getKey()).getCount();
        }
        return sum;
    }

    public HashMap<Integer, Gadget> getAllItems() {
        return allItems;
    }

    public void setAllItems(HashMap<Integer, Gadget> allItems) {
        this.allItems = allItems;
    }

    public HashMap<Integer, Gadget> getSoledItems() {
        return soledItems;
    }

    public void setSoledItems(HashMap<Integer, Gadget> soledItems) {
        this.soledItems = soledItems;
    }

    public HashMap<Integer, Gadget> getVideoGadgets() {
        return videoGadgets;
    }

    public void setVideoGadgets(HashMap<Integer, Gadget> videoGadgets) {
        this.videoGadgets = videoGadgets;
    }

    public HashMap<Integer, Gadget> getAudioGadgets() {
        return audioGadgets;
    }

    public void setAudioGadgets(HashMap<Integer, Gadget> audioGadgets) {
        this.audioGadgets = audioGadgets;
    }

    public int getSoledItemPrice() {
        return soledItemPrice;
    }

    public void setSoledItemPrice(int soledItemPrice) {
        this.soledItemPrice = soledItemPrice;
    }
}
