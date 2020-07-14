/*
 * Write a Java program to iterate through all
 * elements in a linked list starting at the
 * specified position.
 */
package exercises;

import java.util.Iterator;
import java.util.LinkedList;
import java.util.List;

public class Exercise3<T> {
    private LinkedList<T> list = new LinkedList<>();

    public void print() {
        System.out.println(list);
    }

    public void appendToList(T element) {
        list.add(element);
    }

    public void iterateFromIndex (Integer i) {
        Iterator it = list.listIterator(i);
        while (it.hasNext()) {
            System.out.println(it.next());
        }
    }
}
