/*
 * Write a Java program to retrieve but does
 * not remove, the first element of a linked list.
 */

package exercises;

import java.util.LinkedList;

public class Exercise20<T> {
    private LinkedList<T> list = new LinkedList<>();

    public void print() {
        System.out.println(list);
    }

    public void appendToList(T element) {
        list.add(element);
    }

    public T retrieveFirst() {
        return list.peekFirst();
    }
}
