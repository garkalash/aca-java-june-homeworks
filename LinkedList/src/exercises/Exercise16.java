/*
 * Write a Java program to shuffle
 * the elements in a linked list
 */

package exercises;

import java.util.Collections;
import java.util.LinkedList;
import java.util.Random;

public class Exercise16<T> {
    private LinkedList<T> list = new LinkedList<>();

    public void print() {
        System.out.println(list);
    }

    public void appendToList(T element) {
        list.add(element);
    }

    public void shuffleList() {
        Collections.shuffle(list, new Random());
    }
}
