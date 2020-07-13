/*
 * Write a Java program to test an
 * array list is empty or not.
 */
package exercises;

import java.util.ArrayList;

public class Exercise18<T> {
    private ArrayList<T> list = new ArrayList<>();

    public void pushFront(T item) {
        list.add(0, item);
    }

    public void print() {
        System.out.println(list);
    }

    public boolean isListEmpty() {
        return list.isEmpty();
    }
}
