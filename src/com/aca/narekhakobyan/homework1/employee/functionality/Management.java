package com.aca.narekhakobyan.homework1.employee.functionality;

public interface Management {
    void listOfItems();
    void changePrice(Object gadgetObject, Integer price);
    int getStockAMD();
    int getSoldAMD();
    void removeItem(Object gadgetObject);
    void listOfItemsRecordGadgets();
    void listOfItemsVideoGadgets();
}
