package com.aca.narekhakobyan.homework1;

import com.aca.narekhakobyan.homework1.employee.SellManager;
import com.aca.narekhakobyan.homework1.items.concepts.Gadget;
import com.aca.narekhakobyan.homework1.items.functionality.format.FormatSound;
import com.aca.narekhakobyan.homework1.items.functionality.format.FormatVideo;
import com.aca.narekhakobyan.homework1.items.functionality.quality.VideoQuality;
import com.aca.narekhakobyan.homework1.items.models.*;
import com.aca.narekhakobyan.homework1.items.models.PenRecord;

import java.io.*;
import java.util.ArrayList;

public class shop {
    public static void main(String[] args) {
        ArrayList<Gadget> gadgets = new ArrayList<>();
/*
        gadgets.add(new PenVideo(6500, 2, FormatVideo.MP4,
                                                 VideoQuality.VGA, 1));
        gadgets.add(new PenRecord(14000, 9, 8,
                                                FormatSound.MP3, 5, PenColor.Blue));

        gadgets.add(new USBFlashRecord(11000, 9, 8,
                                                FormatSound.MP3, 1));
        gadgets.add(new USBFlashVideo(5000, 2, FormatVideo.MP4,
                                                 VideoQuality.VGA, 1));
        gadgets.add(new Watch(13000, 8, 5,
                                                    FormatSound.MP3, FormatVideo.MP4, VideoQuality.HD, 1));

        SellManager manager = new SellManager(gadgets);

        manager.turnOn();
        manager.printListOfNonWorkingGadgets();
*/
        SellManager manager = new SellManager("C:\\Users\\hakob\\IdeaProjects\\homework1\\src\\com\\aca\\narekhakobyan\\homework1\\input\\product.csv");
        manager.listOfItems();

    }
}
