package com.aca;

import com.aca.gadgets.*;
import com.aca.types.Gadget;

import java.util.ArrayList;
import java.util.List;

public class Main {
    public static void main(String[] args) {
        List<Gadget> gadgets = new ArrayList<>();

        PenVideoRecorder penVideoRecorder = new PenVideoRecorder(2,6500,10,"PenVideoRecorder");
        gadgets.add(penVideoRecorder);
        PenAudioRecorder penAudioRecorder = new PenAudioRecorder(9,14000,10,8,"PenAudioRecorder");
        gadgets.add(penAudioRecorder);
        USBAudio usbAudio = new USBAudio(9,11000,10,8,"UsbAudio");
        gadgets.add(usbAudio);
        USBVideo usbVideo  = new USBVideo(2,5000,10,"UsbVideo");
        gadgets.add(usbVideo);
        Watch watch  = new Watch(5,13000,10,8,"Watch");
        gadgets.add(watch);

        Manager manager = new Manager(gadgets);
        manager.passList(gadgets);
        manager.sellItem(usbAudio.getClass());
        manager.sellItem(usbVideo.getClass());
        manager.passList(gadgets);
        manager.howMuchSold();
        System.out.println(watch.getPrice());
        manager.changePrice(watch,40000);
        System.out.println(watch.getPrice());


    }

}
