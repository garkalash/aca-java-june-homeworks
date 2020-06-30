package com.aca.arminearzumanyan.homeWork1.manager;

import java.util.HashMap;

public interface Manager<T> {

    void changePrice(T item, int newPrice);

    void sellItem(T item);

    int sumPrice(HashMap<Integer, T> itemList);


}
