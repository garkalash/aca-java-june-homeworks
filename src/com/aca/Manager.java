package com.aca;

import com.aca.types.AudioRecorder;
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
                Gadget.allItemsCount-=1;
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


    public List<AudioRecorder> getAllAudioRecorders(){
        List<AudioRecorder> recorders = new ArrayList<>();
        for (Gadget gadget : gadgets) {
            if (gadget instanceof AudioRecorder){
                recorders.add((AudioRecorder)gadget);
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
    public List<AudioRecorder> getAllAudioRecordersByType(AudioRecorder.AudioQuality audioQuality){
        List<AudioRecorder> recorders = new ArrayList<>();
        for (Gadget gadget : gadgets) {
            if (gadget instanceof AudioRecorder){
                AudioRecorder audioRecorder = (AudioRecorder) gadget;
                if(audioRecorder.getAudioQuality() == audioQuality){
                    recorders.add(audioRecorder);
                }
            }
        }
        return recorders;
    }

    public void getListOfItems(List<Gadget> gadgets){
        for (Gadget gadget : gadgets) {
            System.out.println(gadget.getClass()+"(count: "+gadget.getCount()+")");
        }
    }
    public void changePrice(Gadget gadget, int newPrice){
        gadget.setPrice(newPrice);
    }

    public int getSoldAmount() {
        return soldAmount;
    }
}
