/*
 * Write a Java program to remove
 * a specified element from a linked list.
 */

package exercises;

import java.util.LinkedList;

public class Exercise12<T> {
    private LinkedList<T> list = new LinkedList<>();

    public void print() {
        System.out.println(list);
    }

    public void appendToList(T element) {
        list.add(element);
    }

    public boolean removeElement(T element) {
        return list.remove(element);
    }
}
