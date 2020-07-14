/*
 * Write a Java program to replace
 * an element in a linked list
 */
package exercises;

import exceptions.IndexOutOfBounds;

import java.util.LinkedList;

public class Exercise26<T> {
    private LinkedList<T> list = new LinkedList<>();

    public void print() {
        System.out.println(list);
    }

    public void appendToList(T element) {
        list.add(element);
    }

    public T replaceElement(Integer index,T element) throws IndexOutOfBoundsException {
        if (index >= list.size()) {
            throw new IndexOutOfBounds("There is no element with that index");
        }
        return list.set(index, element);
    }
}
