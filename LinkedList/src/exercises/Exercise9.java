/*
 * Write a Java program to insert some
 * elements at the specified position
 * into a linked list.
 */
package exercises;

import java.util.LinkedList;

public class Exercise9<T> {
    private LinkedList<T> list = new LinkedList<>();

    public void print() {
        System.out.println(list);
    }

    public void appendToList(T element) {
        list.add(element);
    }

    public void addListFromIndex(LinkedList<? extends T> sourceList, Integer index) {
        list.addAll(index, sourceList);
    }
}
