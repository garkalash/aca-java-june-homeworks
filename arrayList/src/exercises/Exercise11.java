/*
 * Write a Java program to reverse
 * elements in a array list.
 */

package exercises;

import java.util.ArrayList;
import java.util.Collections;

public class Exercise11<T> {
    private ArrayList<T> list = new ArrayList<>();

    public void pushFront(T item) {
        list.add(0, item);
    }

    public void print() {
        System.out.println(list);
    }

    public void reverseList() {
        Collections.reverse(list);
    }
}
