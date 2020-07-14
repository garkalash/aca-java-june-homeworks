/*
 * Write a Java program to display the
 * elements and their positions in a
 * linked list
 */
package exercises;

import java.util.LinkedList;

public class Exercise11<T> {
    private LinkedList<T> list = new LinkedList<>();

    public void print() {
        System.out.printf("Element\t\t\tIndex\n");
        for (int i = 0; i < list.size(); ++i) {
            System.out.printf("%-8s\t\t%-8s\n", list.get(i).toString(), String.valueOf(i));
        }
    }

    public void appendToList(T element) {
        list.add(element);
    }
}
