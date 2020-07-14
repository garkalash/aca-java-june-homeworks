/*
 * Write a Java program to join
 * two linked lists.
 */
package exercises;

import java.util.Collections;
import java.util.LinkedList;

public class Exercise17<T> {
    private LinkedList<T> list = new LinkedList<>();

    public void print() {
        System.out.println(list);
    }

    public void appendToList(T element) {
        list.add(element);
    }

    public boolean joinLists(LinkedList<? extends T> sourceList) {
        return list.addAll(sourceList);
    }
}
