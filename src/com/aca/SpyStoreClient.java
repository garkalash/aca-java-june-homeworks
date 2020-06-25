package com.aca;

import com.aca.vardanmanasaryan.homework1.management.*;

import java.util.ArrayList;
import java.util.List;

public class SpyStoreClient {
    public static void main(String[] args) {
        StoreManager manager = new StoreManager();
        List<Spygadgets> gadgets = new ArrayList<>();
        gadgets.add(new Videogadgets(6500, 1, "pen", 2, "MP4 Video", "VGA"));
        gadgets.add(new Recordgadgets(14000, 1, "pen", 9, "MP3", "8GB memory"));
        gadgets.add(new Recordgadgets(11000, 1, "USB Flash", 9, "MP3", "8GB memory"));
        gadgets.add(new Videogadgets(5000, 1, "USB Flash", 2, "MP4 Video", "VGA"));
        gadgets.add(new Universalgadget(13000, 1, "Watch", 5, "MP3 & MP4 Video", "HD", "8GB"));

        manager.SellItem();
    }
}
