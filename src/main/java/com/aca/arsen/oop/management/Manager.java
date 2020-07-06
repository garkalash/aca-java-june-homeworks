package com.aca.arsen.oop.management;

import com.aca.arsen.oop.devices.*;
import com.aca.arsen.oop.functionaluty.*;

import java.io.BufferedWriter;
import java.io.FileWriter;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;
import java.util.Random;
import java.util.logging.Level;
import java.util.logging.Logger;

import static java.lang.String.valueOf;


public class Manager {
    public List<Gadget> gadgets = new ArrayList<>();
    private int soldAmount = 0;
    List<Gadget> nonWorkingGadgets = new ArrayList<>();
    Logger logger = Logger.getGlobal();

    public Manager(List<Gadget> gadgets)
    {
        this.gadgets = gadgets;
    }

    public void sellItem (String name)  {

        for(Gadget gadget: gadgets)
        {
            if(gadget.getName().equals(name))
            {
                if(gadget.getCount()>0) {
                    gadget.setCount(gadget.getCount() - 1);
                    soldAmount += gadget.getPrice();
                    try {
                        BufferedWriter tradedetails = new BufferedWriter(new FileWriter("src/main/java/com/aca/arsen/oop/input/trading.csv"));
                        tradedetails.append(gadget.getName());
                        tradedetails.append(",");
                        tradedetails.append(toString(gadget.getPrice()));
                        if(gadget instanceof PenDevice)
                        {
                            tradedetails.append(",");
                            tradedetails.append(((PenDevice) gadget).getPenColor());
                        }
                        tradedetails.newLine();
                        tradedetails.flush();
                        tradedetails.close();

                    } catch (IOException e) {
                        logger.log(Level.SEVERE,"IOException occured");
                        e.printStackTrace();
                    }
                }
                else {
                    logger.log(Level.WARNING,"Gadget not available for selling");
                    return;
                }
            }
        }
    }

    public void turnOnGadget (String name)
    {
        Random rand = new Random();
        boolean on = rand.nextBoolean();
        for(Gadget gadget: gadgets)
        {
            if(gadget.getName().equals(name))
            {
                if(on)
                {
                    System.out.println(gadget.getName() +" successfully turned on");
                    return;
                }
                else {
                    nonWorkingGadgets.add(gadget);
                    gadget.setCount(gadget.getCount()-1);
                    System.out.println(gadget.getName() + " not working");
                    return;
                }
            }
        }

    }

    public List<VideoRecorders> getAllVideoRecorders ()
    {
        List<VideoRecorders> recorders = new ArrayList<>();
        for (Gadget gadget : gadgets) {
            if (gadget instanceof VideoRecorders){
                recorders.add((VideoRecorders)gadget);
            }
        }
        return recorders;
    }

    public List<AudioRecorders> getAllAudioRecorders ()
    {
        List<AudioRecorders> recorders = new ArrayList<>();
        for (Gadget gadget : gadgets) {
            if (gadget instanceof AudioRecorders){
                recorders.add((AudioRecorders)gadget);
            }
        }
        return recorders;
    }

    public List<VideoRecorders> getVideoRecordersByType (VideoRecorders.VideoQuality videoType)
    {
        List<VideoRecorders> recorders = new ArrayList<>();
        for (Gadget gadget : gadgets) {
            if (gadget instanceof VideoRecorders) {
                VideoRecorders videoRecorder = (VideoRecorders) gadget;
                if (videoRecorder.getVideoQuality() == videoType) {
                    recorders.add(videoRecorder);
                }
            }
        }
        return recorders;
    }

    public int soldAmountOfItems ()
    {
        return soldAmount;
    }

    public int stockAmountOfItems ()
    {
            int stockAmount = 0;
            for(Gadget gadget: gadgets)
            stockAmount += gadget.getPrice();
        return stockAmount;
    }
    public void changeItemPrice (Gadget gadget, int newPrice)
    {
        gadget.setPrice(newPrice);
    }



    public String toString (int i)
    {
        String s = Integer.toString(i);
        return s;
    }

}
