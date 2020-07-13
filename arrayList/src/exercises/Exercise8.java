/*
 * Write a Java program to sort
 * a given array list
 */

/*
 * TODO
 *  Implement via generics
 */
package exercises;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

public class Exercise8 {
    private List<Integer> list = new ArrayList<>();

    public void pushFront(Integer item) {
        list.add(0, item);
    }

    public void print() {
        System.out.println(list);
    }

    public void sortList() {
        Collections.sort(list);
    }
}
