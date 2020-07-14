/*
 * Write a Java program of swap
 * two elements in an linked list.
 */
package exercises;

import exceptions.IndexOutOfBounds;

import java.util.Collections;
import java.util.LinkedList;

public class Exercise15<T> {
    private LinkedList<T> list = new LinkedList<>();

    public void print() {
        System.out.println(list);
    }

    public void appendToList(T element) {
        list.add(element);
    }

    public void swapElements(Integer firstIndex, Integer secondIndex) throws IndexOutOfBoundsException {
        if (firstIndex >= list.size() || secondIndex >= list.size()) {
            throw new IndexOutOfBounds("Index out of bounds\n");
        }
        Collections.swap(list, firstIndex, secondIndex);
    }
}
