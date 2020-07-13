/*
 * Write a Java program to shuffle
 * elements in a array list.
 */

package exercises;

import java.util.ArrayList;
import java.util.Collections;
import java.util.Random;

public class Exercise10<T> {
    private ArrayList<T> list = new ArrayList<>();

    public void pushFront(T item) {
        list.add(0, item);
    }

    public void print() {
        System.out.println(list);
    }

    public void shuffle() {
        Collections.shuffle(list, new Random());
    }
}
