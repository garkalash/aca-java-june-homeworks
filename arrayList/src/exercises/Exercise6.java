/*
 * Write a Java program to remove the
 * third element from a array list.
 */

package exercises;

import exceptions.MemoryOutOfBounds;

import java.util.ArrayList;

public class Exercise6<T> {
    private ArrayList<T> list = new ArrayList<>();

    public void pushFront(T item) {
        list.add(0, item);
    }

    public void print() {
        System.out.println(list);
    }

    public void popThirdElement() throws MemoryOutOfBounds {
        if (list.size() <= 3) {
            throw new MemoryOutOfBounds("There is less than 3 elements\n");
        }

        list.remove(2);
    }
}
