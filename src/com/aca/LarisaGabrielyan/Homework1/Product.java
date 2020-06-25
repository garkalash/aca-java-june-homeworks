package com.aca.LarisaGabrielyan.Homework1;

public class Product {
    String name;
    Type videotype;
    VideoQuality videoQuality;
    Sound sound;
    int memory;
    int price;
    int duration;
    int quantity=0;

    public Product(String name, Type videotype, VideoQuality videoQuality, Sound sound, int memory, int price, int duration, int quantity) {
        this.name = name;
        this.videotype = videotype;
        this.videoQuality = videoQuality;
        this.sound = sound;
        this.memory = memory;
        this.price = price;
        this.duration=duration;
        this.quantity = quantity;
    }

}
