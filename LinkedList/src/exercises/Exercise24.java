/*
 * Write a Java program to
 * compare two linked lists
 */
package exercises;

import java.util.Collections;
import java.util.LinkedList;

public class Exercise24<T> {
    private LinkedList<T> list = new LinkedList<>();

    public void print() {
        System.out.println(list);
    }

    public void appendToList(T element) {
        list.add(element);
    }

    public boolean compare(LinkedList<T> listSecond) {
        return list.equals(listSecond);
    }
}
