/*
 * Write a Java program to iterate
 * through all elements in a linked list.
 */
package exercises;

import java.util.LinkedList;
import java.util.List;

public class Exercise2<T> {
    private LinkedList<T> list = new LinkedList<>();

    public void print() {
        for (T listElement : list) {
            System.out.println(listElement);
        }
    }

    public void appendToList(T element) {
        list.add(element);
    }
}
