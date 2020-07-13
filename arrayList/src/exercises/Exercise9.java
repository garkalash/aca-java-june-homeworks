/*
 * Write a Java program to copy
 * one array list into another
 */

package exercises;

import java.util.ArrayList;
import java.util.List;

public class Exercise9<T> {
    private ArrayList<T> list = new ArrayList<>();

    public void pushFront(T item) {
        list.add(0, item);
    }

    public void print() {
        System.out.println(list);
    }

    public List<T> copy() {
        List<T> copiedList = new ArrayList<>();
        for (T it : list) {
            copiedList.add(it);
        }

        return copiedList;
    }
}
