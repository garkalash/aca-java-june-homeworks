/*
 * Write a Java program to insert elements
 * into the linked list at the first and
 * last position.
 */
package exercises;

import java.util.LinkedList;

public class Exercise6<T> {
    private LinkedList<T> list = new LinkedList<>();

    public void print() {
        System.out.println(list);
    }

    public void appendToList(T element) {
        list.add(element);
    }

    public void addElementToFirstPosition(T element) {
        list.addFirst(element);
    }

    public void addElementToLastPosition(T element) {
        list.addLast(element);
    }
}
