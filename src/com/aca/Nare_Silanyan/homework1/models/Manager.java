package com.aca.Nare_Silanyan.homework1.models;

import javafx.util.Pair;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class Manager {
    public static int earned = 0;
    public static int remained = 0;
    public List<String> recordItems = new ArrayList<>();
    public ArrayList<Pair<String,String>> videoItems = new ArrayList<>();




    public void itemsList(Parameters [] parameters){
        System.out.println("Here is the list of Products:");
        System.out.println();
        for(Parameters i: parameters){
            System.out.println("Product Name: "+i.name +", "+ "Count: "+i.count);
            remained = remained+ (i.count*i.price);

            if (Arrays.toString(i.type).contains("Record")){
                recordItems.add(i.name);
            }
            if (Arrays.toString(i.type).contains("Video")){
//                Parameters d = new Parameters(i.name,i.format);
                videoItems.add(new Pair<String,String>(i.name, Arrays.toString(i.format)));
            }



    }
    }

    public void sellItems(Parameters parameters, int quantity){
        if (parameters.count >= quantity){
            System.out.println("Manager Sold The Following Product: " +parameters.name+", "+"Type: "+Arrays.toString(parameters.type)+", " + "Count: "+quantity);

            int current = parameters.count;

            parameters.setCount(current-quantity);

            earned=earned+quantity * parameters.price;
            remained = remained-earned;

        } else {
            System.out.println("Sorry!!! We Don't Have As much As You Want");
        }

    }


    public void changePrice(Parameters parameters, int newPrice){

        remained = remained - parameters.count * (parameters.price - newPrice);
        parameters.setPrice(newPrice);
    }

    public static int getEarned() {
        return earned;
    }

    public static void setEarned(int earned) {
        Manager.earned = earned;
    }

    public static int getRemained() {
        return remained;
    }

    public static void setRemained(int remained) {
        Manager.remained = remained;
    }

    public List<String> getRecordItems() {
        return recordItems;
    }

    public void setRecordItems(List<String> recordItems) {
        this.recordItems = recordItems;
    }

    public ArrayList<Pair<String, String>> getVideoItems() {
        return videoItems;
    }

    public void setVideoItems(ArrayList<Pair<String, String>> videoItems) {
        this.videoItems = videoItems;
    }
}
