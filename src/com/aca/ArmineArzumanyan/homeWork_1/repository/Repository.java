package com.aca.ArmineArzumanyan.homeWork_1.repository;

import java.util.List;

public interface Repository<T> {

    void printItemList(List<T> itemsList);

    List<T> getAll();

    T getItemByCod(int code);




}
