package com.aca.arminearzumanyan.homeWork1.repository;

import java.util.HashMap;

public interface ItemsRepository<T> {

    void getItemsList(HashMap<Integer, T> itemList);

    HashMap<Integer, T> getAll();






}
