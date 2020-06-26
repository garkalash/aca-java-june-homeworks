package com.aca.ArmineArzumanyan.homeWork_1.manager;

import java.util.List;

public interface Manager<T> {

    void changePrice(T item, int newPrice);

    void sailItem(T item);

    int sumPrice(List<T> itemList);


}
