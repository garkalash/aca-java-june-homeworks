/*
 * Write a Java program to replace the second
 * element of a ArrayList with the specified element.
 */

package exercises;

import exceptions.MemoryOutOfBounds;

import java.util.ArrayList;

public class Exercise21<T> {
    private ArrayList<T> list = new ArrayList<>();

    public void pushFront(T item) {
        list.add(0, item);
    }

    public void print() {
        System.out.println(list);
    }

    public void updateSecondElement(T element) throws MemoryOutOfBounds {
        if (list.size() <= 3) {
            throw new MemoryOutOfBounds("There is no element with index 2\n");
        }
        list.set(2, element);
    }
}
