package com.aca.ArmineArzumanyan.HomeWork_1;

import java.util.List;

public interface Repository<T> {

    void printItemList(List<T> itemList);

    int sumPrice(List<T> itemList);

    List<T> getAll();


}
