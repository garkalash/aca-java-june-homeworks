/*
 * Write a Java program to iterate through
 * all elements in a array list
 */

package exercises;

import java.util.ArrayList;

public class Exercise2 {
    private ArrayList<String> colors = new ArrayList<>();

    public void setColor(String color) {
        this.colors.add(color);
    }

    public void print() {
        for (String color : this.colors) {
            System.out.println(color);
        }
    }
}
