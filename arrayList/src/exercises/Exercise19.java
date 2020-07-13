/*
 * Write a Java program to trim the capacity
 * of an array list the current list size
 */

package exercises;

import java.util.ArrayList;

public class Exercise19<T> {
    private ArrayList<T> list = new ArrayList<>();

    public void pushFront(T item) {
        list.add(0, item);
    }

    public void print() {
        System.out.println(list);
    }

    public void trimCapacity() {
        this.list.trimToSize();
    }
}
