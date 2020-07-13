/*
 * Write a Java program to print all the elements
 * of a ArrayList using the position of the elements
 */
package exercises;

import java.util.ArrayList;

public class Exercise22<T> {
    private ArrayList<T> list = new ArrayList<>();

    public void pushFront(T item) {
        list.add(0, item);
    }

    public void print() {
        for (int i = 0; i < list.size(); ++i) {
            System.out.println(list.get(i));
        }
    }
}
