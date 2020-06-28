package com.aca.armineArzumanyan.homeWork_1.repository;

import java.util.List;

public interface ItemsRepository<T> {

    void GetItemsList(List<T> itemList);

    List<T> getAll();

    T getItemByCod(int code);




}
