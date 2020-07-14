/*
 * Write a Java program to check if a
 * particular element exists in a linked list.
 */
package exercises;

import java.util.LinkedList;

public class Exercise22<T> {
    private LinkedList<T> list = new LinkedList<>();

    public void print() {
        System.out.println(list);
    }

    public void appendToList(T element) {
        list.add(element);
    }

    public boolean isExist(T element) {
        return list.contains(element);
    }
}
