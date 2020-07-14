/*
 * Write a Java program to insert the
 * specified element at the end of a
 * linked list.
 */
package exercises;

import java.util.LinkedList;

public class Exercise8<T> {
    private LinkedList<T> list = new LinkedList<>();

    public void print() {
        System.out.println(list);
    }

    public void appendToList(T element) {
        list.add(element);
    }

    public boolean insertFromEnd(T element) {
        return list.offerLast(element);
    }
}
