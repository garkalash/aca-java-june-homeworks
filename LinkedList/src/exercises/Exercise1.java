/*
 * Write a Java program to append the
 * specified element to the end of a linked list
 */
package exercises;

import java.util.LinkedList;

public class Exercise1<T> {
    private LinkedList<T> list = new LinkedList<>();

    public void print() {
        System.out.println(list);
    }

    public void appendToList(T element) {
        list.add(element);
    }
}
