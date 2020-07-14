/*
 * Write a Java program to test an
 * linked list is empty or not
 */
package exercises;

import java.util.LinkedList;

public class Exercise25<T> {
    private LinkedList<T> list = new LinkedList<>();

    public void print() {
        System.out.println(list);
    }

    public void appendToList(T element) {
        list.add(element);
    }

    public boolean isEmpty() {
        return list.isEmpty();
    }
}
