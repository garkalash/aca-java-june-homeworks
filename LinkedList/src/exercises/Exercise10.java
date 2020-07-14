/*
 * Write a Java program to get the first
 * and last occurrence of the specified
 * elements in a linked list.
 */

package exercises;

import java.util.LinkedList;

public class Exercise10<T> {
    private LinkedList<T> list = new LinkedList<>();

    public void print() {
        System.out.println(list);
    }

    public void appendToList(T element) {
        list.add(element);
    }

    public T getFirst() {
        return list.getFirst();
    }

    public T getLast() {
        return list.getLast();
    }
}
