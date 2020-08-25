package com.aca.luiza.booking_task.lib.clone;

import java.util.ArrayList;
import java.util.List;

public class CustomCloneable implements Cloneable {

    protected Object clone() throws CloneNotSupportedException {
        return super.clone();
    }

    public Object copy() throws CloneNotSupportedException {
        return clone();
    }

    public <E extends CustomCloneable> List<E> cloneList(List<E> list) {
        List<E> clone = new ArrayList<E>(list.size());
        for (E item : list) {
            try {
                clone.add((E) item.copy());
            } catch (CloneNotSupportedException e) {
                e.printStackTrace();
            }
        }
        return clone;
    }
}
