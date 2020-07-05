package com.aca;

import com.aca.types.AudioRecorder;
import com.aca.types.Gadget;
import com.aca.types.MemoryGadget;
import com.aca.types.VideoRecorder;

import java.io.*;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.Random;
import java.util.logging.Logger;

public class Manager {
    private final List<Gadget> gadgets;
    private int soldAmount;
    private List<Gadget> workingGadgets=new ArrayList<>();
    private List<Gadget> notWorkingGadgets=new ArrayList<>();
    private Logger logger= Logger.getGlobal();


    public Manager(List<Gadget> gadgets) throws FileNotFoundException {
        this.gadgets = gadgets;
    }

    public void sellItem(String name) throws IOException {
        for (Gadget gadget : gadgets) {
            if (gadget.getName().equals(name)){
                gadget.setCount(gadget.getCount()-1);
                soldAmount += gadget.getPrice();
                Gadget.allItemsCount-=1;
                int memory = 0;
                if (gadget instanceof MemoryGadget){
                    memory = ((MemoryGadget) gadget).getMemoryInGB();
                }
                String[] row = new String[]{
                        gadget.getName(),
                        String.valueOf(gadget.getDuration()),
                        String.valueOf(gadget.getPrice()),
                        String.valueOf(gadget.getCount()),
                        String.valueOf(memory)
                };

                FileWriter csvWriter = new FileWriter("aca-java-june-homeworks/src/com/aca/productList/trading.csv");

                    csvWriter.append(String.join(",", row));
                    csvWriter.append("\n");


                csvWriter.flush();
                csvWriter.close();
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

    public void testGadgets(List<Gadget> gadgets) {
        for (Gadget gadget : gadgets) {
            Random random = new Random();
            boolean onOff= random.nextBoolean();
            if(onOff){
                workingGadgets.add(gadget);
                int id= gadget.getGadgetId();
                    logger.info("Gadget "+id+" is working");
            }else {
                notWorkingGadgets.add(gadget);
                int id= gadget.getGadgetId();
                logger.info("Gadget "+id+" is not working");
            }

        }
    }

    public List<Gadget> getWorkingGadgets() {
        return workingGadgets;
    }

    public List<Gadget> getNotWorkingGadgets() {
        return notWorkingGadgets;
    }
}
