/*
 * Write a Java program to remove first
 * and last element from a linked list.
 */

package exercises;

import exceptions.IndexOutOfBounds;

import java.util.LinkedList;

public class Exercise13<T> {
    private LinkedList<T> list = new LinkedList<>();

    public void print() {
        System.out.println(list);
    }

    public void appendToList(T element) {
        list.add(element);
    }

    public void removeFirst() throws IndexOutOfBoundsException {
        if (list.size() == 0) {
            throw new IndexOutOfBounds("List is empty");
        }
        list.removeFirst();
    }

    public void removeLast() throws IndexOutOfBoundsException {
        if (list.size() == 0) {
            throw new IndexOutOfBounds("List is empty");
        }
        list.removeLast();
    }
}
