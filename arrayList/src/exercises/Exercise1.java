/*
 * Write a Java program to create a new array list,
 * add some colors (string) and print out the collection
 */

package exercises;

import java.util.ArrayList;

public class  Exercise1 {
    private ArrayList<String> colors = new ArrayList<>();

    public void setColor(String color) {
        this.colors.add(color);
    }

    public void print() {
            System.out.println(this.colors);
    }
}
