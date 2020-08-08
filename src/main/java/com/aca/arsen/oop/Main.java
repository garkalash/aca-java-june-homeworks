package com.aca.arsen.oop;

import com.aca.arsen.oop.devices.*;
import com.aca.arsen.oop.functionaluty.*;
import com.aca.arsen.oop.management.Manager;
import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;
import java.util.logging.Level;
import java.util.logging.Logger;


public class Main {
    private static final Logger logger = Logger.getGlobal();

    public static void main(String[] args) throws IOException {
        List<Gadget> gadgetList = copyListOfItems("src/main/java/com/aca/arsen/oop/input/product.csv");
        Manager manager1 = new Manager(gadgetList);
        manager1.sellItem("Watch");
        manager1.sellItem("PenDevice");
        System.out.println(manager1.getAllAudioRecorders());
        System.out.println(manager1.getVideoRecordersByType(VideoRecorders.VideoQuality.HD));
        System.out.println(manager1.stockAmountOfItems());
        System.out.println(manager1.soldAmountOfItems());
        manager1.turnOnGadget("Watch");
        manager1.turnOnGadget("PenDevice");
        manager1.turnOnGadget("USBFlasVideoDevice");
    }

    public static List<Gadget> copyListOfItems (String pathOfProducts)
    {
        List<Gadget> gadgets = new ArrayList<>();
        try
        {
            BufferedReader readListOfItems = new BufferedReader(new FileReader(pathOfProducts));
            String row = "";
            String separater = ",";

            while((row = readListOfItems.readLine()) != null)
            {
                if(row.contains("PenDevice"))
                {
                    String[] gadgetDetails = row.split(separater);
                    System.out.println(gadgetDetails[0]);
                    gadgets.add(new PenDevice(gadgetDetails[0],Integer.parseInt(gadgetDetails[1]),Integer.parseInt(gadgetDetails[2]),Integer.parseInt(gadgetDetails[3]),Integer.parseInt(gadgetDetails[4]),gadgetDetails[6]));
                }
                else if(row.contains("PenVideoDevice"))
                {
                    String[] gadgetDetails = row.split(separater);
                    System.out.println(gadgetDetails[0]);
                    gadgets.add(new PenVideoDevice(gadgetDetails[0],Integer.parseInt(gadgetDetails[1]),Integer.parseInt(gadgetDetails[2]),Integer.parseInt(gadgetDetails[3])));
                }
                else if (row.contains("USBFlashDevice"))
                {
                    String[] gadgetDetails = row.split(separater);
                    gadgets.add(new USBFlashDevice(gadgetDetails[0],Integer.parseInt(gadgetDetails[1]),Integer.parseInt(gadgetDetails[2]),Integer.parseInt(gadgetDetails[3]),Integer.parseInt(gadgetDetails[4])));
                }
                else if (row.contains("USBFlashVideoDevice"))
                {
                    String[] gadgetDetails = row.split(separater);
                    gadgets.add(new USBFlashVideoDeivce(gadgetDetails[0],Integer.parseInt(gadgetDetails[1]),Integer.parseInt(gadgetDetails[2]),Integer.parseInt(gadgetDetails[3])));
                }
                else if (row.contains("Watch"))
                {
                    String[] gadgetDetails = row.split(separater);
                    gadgets.add(new Watch(gadgetDetails[0],Integer.parseInt(gadgetDetails[1]),Integer.parseInt(gadgetDetails[2]),Integer.parseInt(gadgetDetails[3]),Integer.parseInt(gadgetDetails[4])));
                }
            }

        }
         catch (IOException e) {
            logger.log(Level.SEVERE, "IOException found");
            e.printStackTrace();
        }
        return gadgets;
    }

}