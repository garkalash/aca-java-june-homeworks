/*
 * Write a Java program to remove and
 * return the first element of a linked list.
 */
package exercises;

import java.util.LinkedList;

public class Exercise19<T> {
    private LinkedList<T> list = new LinkedList<>();

    public void print() {
        System.out.println(list);
    }

    public void appendToList(T element) {
        list.add(element);
    }

    public T popFirst() {
        return list.pop();
    }
}
