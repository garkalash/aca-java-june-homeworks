package com.aca;

import com.aca.exceptions.WrongProductData;
import com.aca.items.*;
import com.aca.types.Gadget;

import java.io.BufferedReader;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.util.ArrayList;
import java.util.List;
import java.util.logging.Logger;

public class Client {

    public static void main(String[] args) throws IOException {
        List<Gadget> gadgets = getProductList("aca-java-june-homeworks/src/com/aca/productList/product.csv");
        Manager manager = new Manager(gadgets);

       manager.testGadgets(gadgets);
        System.out.println(manager.getWorkingGadgets());
       System.out.println(manager.getNotWorkingGadgets());
        for (Gadget gadget : gadgets) {
            System.out.println(gadget.getName());
        }
        manager.sellItem("Watch");

    }
    private static List<Gadget> getProductList(String listPath){
        Path path = Paths.get(listPath);
        Logger logger =Logger.getGlobal();
        List<Gadget> gadgets = new ArrayList<>();
        try(BufferedReader br = new BufferedReader(new FileReader(path.toFile()))){
            String row;
            while ((row = br.readLine()) != null){
                String[] productData = row.split(";");
                if(productData.length == 5){
                    Integer duration = Integer.valueOf(productData[1].trim());
                    Integer price = Integer.valueOf(productData[2].trim());
                    Integer count = Integer.valueOf(productData[3].trim());
                    Integer memory = Integer.valueOf(productData[4].trim());
                    switch (productData[0]){
                        case "PenVideoRecorder" :
                            PenVideoRecorder penVideoRecorder = new PenVideoRecorder(duration,price,count,"PenVideoRecorder");
                            gadgets.add(penVideoRecorder);
                            break;
                        case "BluePenAudioRecorder" :
                            BluePenAudioRecorder bluePenAudioRecorder = new BluePenAudioRecorder(duration,price,count,memory,"BluePenAudioRecorder");
                            gadgets.add(bluePenAudioRecorder);
                            break;
                        case "USBVideo" :
                            USBVideo usbVideo = new USBVideo(duration,price,count,"USBVideo");
                            gadgets.add(usbVideo);
                            break;
                        case "USBAudio" :
                            USBAudio usbAudio = new USBAudio(duration,price,count,memory,"USBAudio");
                            gadgets.add(usbAudio);
                            break;
                        case "RedPenAudioRecorder" :
                            RedPenAudioRecorder redPenAudioRecorder = new RedPenAudioRecorder(duration,price,count,memory,"RedPenAudioRecorder");
                            gadgets.add(redPenAudioRecorder);
                            break;
                        case "Watch" :
                            Watch watch = new Watch(duration,price,count,memory,"Watch");
                            gadgets.add(watch);
                            break;
                    }
                }else {
                    logger.warning("Wrong product data");
                    throw new WrongProductData();
                }
            }

        } catch (IOException e) {
            e.printStackTrace();
        }
        return gadgets;
    }

}
