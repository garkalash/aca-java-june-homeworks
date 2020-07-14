/*
 * Write a Java program to clone an
 * linked list to another linked list.
 */
package exercises;

import java.util.LinkedList;

public class Exercise18<T> {
    private LinkedList<T> list = new LinkedList<>();

    public void print() {
        System.out.println(list);
    }

    public void appendToList(T element) {
        list.add(element);
    }

    public LinkedList<? extends T> cloneList() {
        return (LinkedList<? extends T>) list.clone();
    }
}
