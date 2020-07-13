/*
 * Write a Java program to increase
 * the size of an array list.
 */
package exercises;

import java.util.ArrayList;

public class Exercise20<T> {
    private ArrayList<T> list = new ArrayList<>();

    public void pushFront(T item) {
        list.add(0, item);
    }

    public void print() {
        System.out.println(list);
    }

    public void changeSize(Integer capacity) {
        list.ensureCapacity(capacity);
    }
}
