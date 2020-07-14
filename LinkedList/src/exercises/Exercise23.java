/*
 * Write a Java program to convert a
 * linked list to array list.
 */
package exercises;

import java.util.ArrayList;
import java.util.LinkedList;

public class Exercise23<T> {
    private LinkedList<T> list = new LinkedList<>();

    public void print() {
        System.out.println(list);
    }

    public void appendToList(T element) {
        list.add(element);
    }

    public ArrayList<T> convertToArrayList() {
        return new ArrayList<>(list);
    }
}
