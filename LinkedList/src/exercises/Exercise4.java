/*
 * Write a Java program to iterate
 * a linked list in reverse order
 */
package exercises;

import java.util.Iterator;
import java.util.LinkedList;

public class Exercise4<T> {
    private LinkedList<T> list = new LinkedList<>();

    public void print() {
        System.out.println(list);
    }

    public void appendToList(T element) {
        list.add(element);
    }

    public void iterateReverse() {
        Iterator it = list.descendingIterator();
        while (it.hasNext()) {
            System.out.println(it.next());
        }
    }
}
