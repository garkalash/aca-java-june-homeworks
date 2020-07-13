/*
 * Write a Java program
 * to join two array lists
 */

package exercises;

import java.util.ArrayList;
import java.util.List;

public class Exercise15<T> {
    private ArrayList<T> list = new ArrayList<>();

    public void pushFront(T item) {
        list.add(0, item);
    }

    public void print() {
        System.out.println(list);
    }

    public void joinLists(List<T> lst) {
        lst.addAll(list);
    }
}
