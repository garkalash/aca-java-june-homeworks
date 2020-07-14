/*
 * Write a Java program to retrieve but
 * does not remove, the last element of a linked list
 */
package exercises;

import java.util.LinkedList;

public class Exercise21<T> {
    private LinkedList<T> list = new LinkedList<>();

    public void print() {
        System.out.println(list);
    }

    public void appendToList(T element) {
        list.add(element);
    }

    public T retrieveLast() {
        return list.peekLast();
    }
}
