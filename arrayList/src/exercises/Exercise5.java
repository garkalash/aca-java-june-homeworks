/*
 * Write a Java program to update specific
 * array element by given element.
 */

package exercises;

import java.util.ArrayList;

public class Exercise5<T> {
    private ArrayList<T> list = new ArrayList<>();

    public void pushFront(T item) {
        list.add(0, item);
    }

    public void print() {
        System.out.println(list);
    }

    public void updateListElement(T oldValue, T newValue) {
        int index = list.indexOf(oldValue);
        list.remove(index);
        list.add(index, newValue);
    }
}
