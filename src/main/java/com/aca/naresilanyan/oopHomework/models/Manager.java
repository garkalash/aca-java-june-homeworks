package com.aca.naresilanyan.oopHomework.models;


import java.util.*;
import java.util.logging.Logger;

public class Manager {
    private  int earned = 0;
    private  int remained = 0;
    private List<Gadget> gadgets = new ArrayList<>();
    private Logger logger = Logger.getGlobal();


//    public Manager (Gadget [] gadget){
//        for (Gadget i : gadget) {
//            gadgets.add(i);
//
//        }
//
//
//        for (Gadget j : gadget) {
//            logger.info("Product Name: " + j.name + ", " + "Count: " + j.count);
//            remained = remained + (j.count * j.price);
//        }
//
//
//    }

    public Manager (List<Gadget> gadget){
        for (Gadget i : gadget) {
            gadgets.add(i);

        }


        for (Gadget j : gadget) {
            logger.info("Product Name: " + j.name + ", " + "Count: " + j.count);
            remained = remained + (j.count * j.price);
        }


    }





    public  int getEarned() {
        return earned;
    }

    public  void setEarned(int earned) {
        this.earned = earned;
    }

    public  int getRemained() {
        return remained;
    }

    public  void setRemained(int remained) {
        this.remained = remained;
    }






    public void sellItem(String name, String quality, int quantity){


        for(Gadget gadget:gadgets){

            if(name.equals(gadget.name) & gadget.format.contains(quality)){
                if(gadget.count >= quantity){
                    int current = gadget.count;
                    gadget.setCount(current-quantity);
                    earned=earned+quantity * gadget.price;
                    remained = remained-earned;
                    return;
                } else {
                    logger.info("Sorry!!! We Don't Have As much As You Want");
                    return;
                }

            }

        }
    }


    public List<String> getVideoRecorders(){
        List<String> videoRecorders = new ArrayList<>();
        for(Gadget gadget: gadgets){
            if(gadget instanceof VideoDevice & gadget.count != 0){
                videoRecorders.add(gadget.name);
            }


        }

        return videoRecorders;
    }

    public List<String> getAudioRecorders(){
        List<String> audioRecorders = new ArrayList<>();
        for(Gadget gadget: gadgets){
            if(gadget instanceof AudioDevice & gadget.count != 0){
                audioRecorders.add(gadget.name);
            }


        }

        return audioRecorders;
    }


    public Map<String,List<String>> getVideoRecordersByType(String videoType){
        Map<String,List<String>> videoRecorders = new HashMap<String,List<String>>();
        for(Gadget gadget: gadgets){
            if(gadget instanceof VideoDevice){
                if (gadget.format.contains(videoType)){
                    videoRecorders.put(gadget.name,gadget.format);
                }
            }else if (gadget instanceof AudioDevice){
                // This part doesn't work correctly
                logger.info("Sorry but you must check only Video types");
            }

        }

        return videoRecorders;
    }


    public void changeGadgetPrice(String name, String quality, int newPrice){
        for(Gadget gadget:gadgets){
            if(name.equals(gadget.name) & gadget.format.contains(quality)){
                    remained=remained-gadget.count *(gadget.price-newPrice);
                    gadget.setPrice(newPrice);
                    return;

            }
        }
    }









}
