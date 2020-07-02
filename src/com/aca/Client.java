package com.aca;

import com.aca.items.*;
import com.aca.types.AudioRecorder;
import com.aca.types.Gadget;
import com.aca.types.VideoRecorder;

import java.io.FileNotFoundException;
import java.util.ArrayList;
import java.util.List;

public class Client {
    public static void main(String[] args) throws FileNotFoundException {
        List<Gadget> gadgets = new ArrayList<>();

        RedPenAudioRecorder redPenAudioRecorderPenVideoRecorder = new RedPenAudioRecorder(2,6500,10,10);
        gadgets.add(redPenAudioRecorderPenVideoRecorder);
        PenAudioRecorder penAudioRecorder = new PenAudioRecorder(9,14000,10,8);
        gadgets.add(penAudioRecorder);
        USBAudio usbAudio = new USBAudio(9,11000,10,8);
        gadgets.add(usbAudio);
        USBVideo usbVideo  = new USBVideo(2,5000,10);
        gadgets.add(usbVideo);
        Watch watch  = new Watch(5,13000,10,8);
        gadgets.add(watch);

        Manager manager = new Manager(gadgets);
//        manager.passList(gadgets);
//        manager.sellItem(usbAudio.getClass());
//        manager.sellItem(usbVideo.getClass());
//        manager.getListOfItems(gadgets);
//        System.out.println(manager.getSoldAmount());
//        System.out.println(watch.getPrice());
//        manager.changePrice(watch,40000);
//        System.out.println(watch.getPrice());
//        System.out.println(Gadget.allItemsCount);
//        for (VideoRecorder allVideoRecorder : manager.getAllVideoRecorders()) {
//            System.out.println(allVideoRecorder.getClass());
//        }
//        for (AudioRecorder allAudioRecorder : manager.getAllAudioRecorders()) {
//            System.out.println(allAudioRecorder.getClass());
//        }
        manager.testGadgets(gadgets);
        System.out.println(manager.getWorkingGadgets());
        System.out.println(manager.getNotWorkingGadgets());

    }

}
