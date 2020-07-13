/*
 * Write a Java program of swap
 * two elements in an array list
 */
package exercises;

import exceptions.MemoryOutOfBounds;

import java.util.ArrayList;
import java.util.Collections;

public class Exercise14<T> {
    private ArrayList<T> list = new ArrayList<>();

    public void pushFront(T item) {
        list.add(0, item);
    }

    public void print() {
        System.out.println(list);
    }

    public void swapListElements(Integer i, Integer j) throws MemoryOutOfBounds {
        if (i >= list.size()) {
            throw new MemoryOutOfBounds("First index out of bounds: " + i);
        }

        if (j >= list.size()) {
            throw new MemoryOutOfBounds("Second index out of bounds: " + j);
        }

        Collections.swap(list, i, j);
    }
}
