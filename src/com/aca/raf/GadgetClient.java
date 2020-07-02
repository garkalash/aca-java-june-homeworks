package com.aca.raf;

import com.aca.raf.management.*;

import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

public class GadgetClient {
    public static void main(String[] args) {
//        List<Gadget> gadgets = new ArrayList<>();
        List<Gadget> gadgetList = new ArrayList<>();

        String line = "";
        String splitBy = ",";
        try
        {

            BufferedReader br = new BufferedReader(new FileReader("product.csv"));
            while ((line = br.readLine()) != null)
            {
                String[] gadget = line.split(splitBy);
                if (gadget[0].equals("PenAudioRecorder")){
                    Gadget penAudioRecorder = new PenAudioRecorder(Integer.parseInt(gadget[1]), Integer.parseInt(gadget[2]), Integer.parseInt(gadget[3]), Integer.parseInt(gadget[4]), gadget[5]);
                    gadgetList.add(penAudioRecorder);
                }
            }
        }
        catch (IOException e)
        {
            e.printStackTrace();
        }

        //
        Gadget usbAudio = new USBAudio(9, 11000, 10, 8);
        gadgetList.add(usbAudio);
        gadgetList.add(new PenVideoRecorder(2, 6500, 7, "blue"));
        Manager gadgetManeger = new Manager(gadgetList);
        for (Gadget gadget: gadgetList) {
            gadgetManeger.SellItem(gadget.getClass());
        }
        
        System.out.println(gadgetManeger.getInStockAmount());
        System.out.println(gadgetManeger.getSoldAmount());
        usbAudio.setPrice(10000);
        gadgetManeger.checkGadgets();
    }
}
