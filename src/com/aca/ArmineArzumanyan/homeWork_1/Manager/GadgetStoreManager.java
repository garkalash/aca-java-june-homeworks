package com.aca.ArmineArzumanyan.homeWork_1.Manager;

import com.aca.ArmineArzumanyan.homeWork_1.Items.Gadget.Gadget;
import com.aca.ArmineArzumanyan.homeWork_1.Repository.GadgetsRepository;

import java.util.ArrayList;
import java.util.List;

public class GadgetStoreManager implements Manager<Gadget> {


    public GadgetStoreManager() {
    }

    public GadgetsRepository repository = new GadgetsRepository();

    public List<Gadget> soledItems = new ArrayList<>();
    public int soledItemPrice = 0;
    public List<Gadget> allItems = repository.getAll();
    public List<Gadget> videoGadgets = new ArrayList<>();
    public List<Gadget> audioGadgets = new ArrayList<>();

    public void setAudioGadgets() {
        for (Gadget gadget : allItems) {
            if (gadget.getGadgetType() == Gadget.GadgetType.AUDIO || gadget.getGadgetType() == Gadget.GadgetType.AUDIO_VIDEO) {
                audioGadgets.add(gadget);
            }
        }
    }

    public void setVideoGadgets() {
        for (Gadget gadget : allItems) {
            if (gadget.getGadgetType() == Gadget.GadgetType.VIDEO || gadget.getGadgetType() == Gadget.GadgetType.AUDIO_VIDEO) {
                videoGadgets.add(gadget);
            }
        }
    }

    @Override
    public void changePrice(Gadget gadget, int newPrice) {
        gadget.setPrice(newPrice);
    }

    @Override
    public void sailItem(Gadget gadget) {
        for (Gadget gadget1 : allItems) {
            if (gadget1.equals(gadget)) {
                gadget.setCount(gadget.getCount() - 1);
                break;
            }
        }
        soledItemPrice += gadget.getPrice();
    }

    @Override
    public int sumPrice(List<Gadget> gadgetList) {
        int sum = 0;
        for (Gadget gadget : gadgetList) {

            sum += gadget.getPrice() * gadget.getCount();
        }
        return sum;
    }

}
