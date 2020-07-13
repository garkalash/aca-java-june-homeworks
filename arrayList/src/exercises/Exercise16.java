/*
 * Write a Java program to clone an
 * array list to another array list
 */
package exercises;

import java.util.ArrayList;
import java.util.List;

public class Exercise16<T> {
    private ArrayList<T> list = new ArrayList<>();

    public void pushFront(T item) {
        list.add(0, item);
    }

    public void print() {
        System.out.println(list);
    }

    public List<? super T> cloneList() {
        return (List<T>) list.clone();
    }
}
