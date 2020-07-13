/*
 * Write a Java program to
 * compare two array lists
 */
package exercises;

import java.util.ArrayList;
import java.util.List;

public class Exercise13<T> {
    private ArrayList<T> list = new ArrayList<>();

    public void pushFront(T item) {
        list.add(0, item);
    }

    public void print() {
        System.out.println(list);
    }

    public boolean compareList(List<T> lst) {
        if (lst.equals(list)) {
            return true;
        }

        return false;
    }

}
