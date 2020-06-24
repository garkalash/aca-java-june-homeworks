package com.aca.narekhakobyan.homework1.tests;

import com.aca.narekhakobyan.homework1.employee.GadgetManager;
import com.aca.narekhakobyan.homework1.items.concepts.Gadget;
import com.aca.narekhakobyan.homework1.items.functionality.format.FormatSound;
import com.aca.narekhakobyan.homework1.items.functionality.format.FormatVideo;
import com.aca.narekhakobyan.homework1.items.functionality.quality.VideoQuality;
import com.aca.narekhakobyan.homework1.items.models.GadgetRecordVideoWithMemory;
import com.aca.narekhakobyan.homework1.items.models.GadgetRecordWithMemory;
import com.aca.narekhakobyan.homework1.items.models.GadgetVideoWithoutMemory;

import java.util.ArrayList;

public class TestSellItem {
    protected final void RunTest() {
        ArrayList<Gadget> gadgets = new ArrayList<>();
        gadgets.add(new GadgetVideoWithoutMemory("Pen Video", 6500, 2, FormatVideo.MP4,
                VideoQuality.VGA, 1));
        gadgets.add(new GadgetRecordWithMemory("Pen Record", 14000, 9, 8,
                FormatSound.MP3, 1));
        gadgets.add(new GadgetRecordWithMemory("USB FLASH", 11000, 9, 8,
                FormatSound.MP3, 1));
        gadgets.add(new GadgetVideoWithoutMemory("USB FLASH", 5000, 2, FormatVideo.MP4,
                VideoQuality.VGA, 1));
        gadgets.add(new GadgetRecordVideoWithMemory("Watch", 13000, 8, 5,
                FormatSound.MP3, FormatVideo.MP4, VideoQuality.HD, 1));

        GadgetManager manager = new GadgetManager(gadgets);
        System.out.println("Before sell sellAMD is: " + manager.getSoldAMD());
        System.out.println("Before sell stockAMD is: " + manager.getStockAMD());
        manager.sellItem(gadgets.get(1), 3);
        System.out.println("After sell sellAMD is: " + manager.getSoldAMD());
        System.out.println("After sell stockAMD is: " + manager.getStockAMD());
    }
}
