package com.aca.LarisaGabrielyan.Homework1;

public interface Steps {
    void ListWithQuantity(String name, Type videotype, VideoQuality videoQuality, Sound sound, int memory, int price, int duration, int quantity);
    void sell(String name);
    int sold();
    int stock();
    void ItemList();
    void PriceChange(String name,int price);
    void VideoItem(Type type);
}
