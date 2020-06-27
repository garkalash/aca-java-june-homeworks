package com.aca;

import com.aca.types.Gadget;
import com.aca.types.VideoRecorder;

import java.util.ArrayList;
import java.util.List;

public class Manager {
    private final List<Gadget> gadgets;
    private int soldAmount;

    public Manager(List<Gadget> gadgets) {
        this.gadgets = gadgets;
    }

    public void sellItem(Class classOfGadget){
        for (Gadget gadget : gadgets) {
            if (gadget.getClass()==classOfGadget){
                gadget.setCount(gadget.getCount()-1);
                soldAmount += gadget.getPrice();
            }
        }
    }

    public List<VideoRecorder> getAllVideoRecorders(){
        List<VideoRecorder> recorders = new ArrayList<>();
        for (Gadget gadget : gadgets) {
            if (gadget instanceof VideoRecorder){
                recorders.add((VideoRecorder)gadget);
            }
        }
        return recorders;
    }

    public List<VideoRecorder> getAllVideoRecordersByType(VideoRecorder.VideoQuality videoQuality){
        List<VideoRecorder> recorders = new ArrayList<>();
        for (Gadget gadget : gadgets) {
            if (gadget instanceof VideoRecorder){
                VideoRecorder videoRecorder = (VideoRecorder) gadget;
                if(videoRecorder.getVideoQuality() == videoQuality){
                    recorders.add(videoRecorder);
                }
            }
        }
        return recorders;
    }

    public void passList(List<Gadget> gadgets){
        for (Gadget gadget : gadgets) {
            System.out.println(gadget.getName()+"(count: "+gadget.getCount()+")");
        }
    }
    public void howMuchSold(){
        System.out.println(soldAmount + "AMD");
    }
    public void changePrice(Gadget gadget, int newPrice){
        gadget.setPrice(newPrice);
    }


}
