/*
 * Write a Java program to remove all
 * the elements from a linked list.
 */
package exercises;

import java.util.LinkedList;

public class Exercise14<T> {
    private LinkedList<T> list = new LinkedList<>();

    public void print() {
        System.out.println(list);
    }

    public void appendToList(T element) {
        list.add(element);
    }

    public boolean removeAll() {
        return list.removeAll(list);
    }
}
