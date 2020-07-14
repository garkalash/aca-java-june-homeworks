/*
 * Write a Java program to insert the specified
 * element at the specified position in the linked list.
 */

package exercises;

import java.util.LinkedList;

public class Exercise5<T> {
    private LinkedList<T> list = new LinkedList<>();

    public void print() {
        System.out.println(list);
    }

    public void appendToList(T element) {
        list.add(element);
    }

    public void addByIndex(Integer i, T element) {
        list.add(i, element);
    }
}
