/*
 * Write a Java program to insert the specified
 * element at the front of a linked list.
 */

package exercises;

import java.util.LinkedList;

public class Exercise7<T> {
    private LinkedList<T> list = new LinkedList<>();

    public void print() {
        System.out.println(list);
    }

    public void appendToList(T element) {
        list.add(element);
    }

    public boolean pushFront(T element) {
        return list.offerFirst(element);
    }

}
