package com.aca.narekhakobyan.homework;

import com.aca.narekhakobyan.homework.employee.SellManager;
import com.aca.narekhakobyan.homework.items.concepts.Gadget;
import com.aca.narekhakobyan.homework.items.functionality.format.FormatSound;
import com.aca.narekhakobyan.homework.items.functionality.format.FormatVideo;
import com.aca.narekhakobyan.homework.items.functionality.quality.VideoQuality;
import com.aca.narekhakobyan.homework.items.models.*;

import java.util.ArrayList;


public class shop {
    public static void main(String[] args) {
        ArrayList<Gadget> gadgets = new ArrayList<Gadget>();
        gadgets.add(new PenVideo(FormatVideo.MP4, VideoQuality.VGA, 2, 6500, 0));
        gadgets.add(new PenRecord(FormatSound.MP3, 8, 9, 14000, 0, PenRecord.PenColor.Blue));
        gadgets.add(new USBFlashRecord(FormatSound.MP3, 8, 9, 11000, 0));
        gadgets.add(new USBFlashVideo(FormatVideo.MP4, VideoQuality.VGA, 2, 5000, 0));
        gadgets.add(new Watch(FormatSound.MP3, FormatVideo.MP4, VideoQuality.HD, 8, 5, 13000, 0));

        SellManager manager = new SellManager(gadgets);
        manager.addFromFile(Watch.class, PenRecord.class);
        manager.listOfItems();

       // manager.sellItem("Watch");

        manager.listOfItemsVideoGadgets();
        manager.turnOn();
        manager.listOfItems();
    }
}
