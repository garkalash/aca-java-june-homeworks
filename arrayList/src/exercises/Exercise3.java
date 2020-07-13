/*
 * Write a Java program to insert an element
 * into the array list at the first position.
 */

package exercises;

import java.util.ArrayList;

public class Exercise3<T> {
    private ArrayList<T> list = new ArrayList<>();

    public void pushFront(T item) {
        list.add(0, item);
    }

    public void print() {
        System.out.println(list);
    }
}
