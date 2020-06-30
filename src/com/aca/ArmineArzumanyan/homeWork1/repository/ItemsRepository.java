package com.aca.arminearzumanyan.homework1.repository;

import java.util.HashMap;

public interface ItemsRepository<T> {

    void getItemsList(HashMap<Integer, T> itemList);

    HashMap<Integer, T> getAll();






}
