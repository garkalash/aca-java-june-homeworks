/*
 * Write a Java program to
 * empty an array list.
 */
package exercises;

import java.util.ArrayList;

public class Exercise17<T> {
    private ArrayList<T> list = new ArrayList<>();

    public void pushFront(T item) {
        list.add(0, item);
    }

    public void print() {
        System.out.println(list);
    }

    public void emptyList() {
        list.removeAll(list);
    }
}
