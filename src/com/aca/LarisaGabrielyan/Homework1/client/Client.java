package com.aca.LarisaGabrielyan.Homework1.client;

import com.aca.LarisaGabrielyan.Homework1.Product;
import com.aca.LarisaGabrielyan.Homework1.Sound;
import com.aca.LarisaGabrielyan.Homework1.Type;
import com.aca.LarisaGabrielyan.Homework1.VideoQuality;

import java.time.Duration;
import java.util.ArrayList;
import java.util.Scanner;

public class Client {
    public static void main(String[] args) {
        ArrayList<Product> products = new ArrayList<Product>();
        products.add(new Product("Pen", Type.Video, VideoQuality.VGA, Sound.MP4, 0, 6500, 2, 2));
        products.add(new Product("USB flash", Type.Record, VideoQuality.VGA, Sound.MP3, 8,11000, 9, 1));
        products.add(new Product("USB flash", Type.Video, VideoQuality.VGA, Sound.MP4, 0, 5000, 2, 5));
        products.add(new Product("Watch", Type.Record, VideoQuality.HD, Sound.MP4, 8, 13000, 5, 1));
//        System.out.println("Elements of ArrayList of String Type: "+products);
        System.out.print(products);
    }

}
