/*
 * Write a Java program to retrieve an element
 * (at a specified index) from a given array list
 */

package exercises;

import exceptions.MemoryOutOfBounds;

import java.util.ArrayList;

public class Exercise4<T> {
    private ArrayList<T> list = new ArrayList<>();

    public void pushFront(T item) {
        list.add(0, item);
    }

    public void print() {
        System.out.println(list);
    }

    public void popByIndex(Integer index) throws MemoryOutOfBounds {
        if (index >= list.size()) {
            throw new MemoryOutOfBounds("There is no such index\n");
        }
        list.remove(list.get(index));
    }
}
