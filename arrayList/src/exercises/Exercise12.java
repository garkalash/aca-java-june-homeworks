/*
 * Write a Java program to extract
 * a portion of a array list.
 */

package exercises;

import java.util.ArrayList;
import java.util.List;

public class Exercise12<T> {
    private ArrayList<T> list = new ArrayList<>();

    public void pushFront(T item) {
        list.add(0, item);
    }

    public void print() {
        System.out.println(list);
    }

    public List<T> subList(int index) {
        List<T> dst = new ArrayList<>();
        for (int i = index; i < list.size(); ++i) {
            dst.add(list.get(i));
        }

        return dst;
    }
}
