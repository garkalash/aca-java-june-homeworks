/*
 * Write a Java program to search
 * an element in a array list.
 */
package exercises;

import java.util.ArrayList;

public class Exercise7<T> {
    private ArrayList<T> list = new ArrayList<>();

    public void pushFront(T item) {
        list.add(0, item);
    }

    public void print() {
        System.out.println(list);
    }

    public boolean find(T item) {
        for (T it : list) {
            if (it.equals(item))
                return true;
        }

        return false;
    }
}
