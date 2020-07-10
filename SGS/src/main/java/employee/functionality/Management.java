package employee.functionality;

import items.concepts.Gadget;

import java.util.ArrayList;

public interface Management {
    ArrayList<Gadget> getListOfItems();
    void changePrice(Object gadgetObject, Integer price);
    int getStockAMD();
    int getSoldAMD();
    void removeItem(Object gadgetObject);
    ArrayList<Gadget> getListOfItemsRecordGadgets();
    ArrayList<Gadget> getListOfItemsVideoGadgets();
}
