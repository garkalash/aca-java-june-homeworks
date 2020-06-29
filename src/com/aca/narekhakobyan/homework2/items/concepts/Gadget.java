package com.aca.narekhakobyan.homework1.items.concepts;

import java.util.Objects;
import java.util.Scanner;

public abstract class Gadget {
    private Integer price;
    private Integer count;
    private final Integer recDuration;

    protected Gadget(Integer price, Integer recDuration, Integer count) {

        while (!isCorrectPrice(price)) {
            System.out.println("Incorrect price. Please reenter.");
            Scanner in = new Scanner(System.in);
            price = in.nextInt();
        }

        this.price = price;

        while (!isCorrectCount(count)) {
            System.out.println("Incorrect quantity. Please reenter.");
            Scanner in = new Scanner(System.in);
            count = in.nextInt();
        }

        this.count = count;

        while (!isCorrectRecDuration(price)) {
            System.out.println("Incorrect price. Please reenter.");
            Scanner in = new Scanner(System.in);
            recDuration = in.nextInt();
        }

        this.recDuration = recDuration;
    }

    protected Gadget(String line) {
        String cvsSplitBy = ",";
        String[] product = line.split(cvsSplitBy);
        while (!isCorrectPrice(Integer.valueOf(product[2]))) {
            System.out.println("Incorrect price. Please reenter.");
            Scanner in = new Scanner(System.in);
            product[2] = in.next();
        }

        this.price = Integer.valueOf(product[2]);

        while (!isCorrectCount(Integer.valueOf(product[3]))) {
            System.out.println("Incorrect quantity. Please reenter.");
            Scanner in = new Scanner(System.in);
            product[3] = in.next();
        }

        this.count = Integer.valueOf(product[3]);

        while (!isCorrectRecDuration(Integer.valueOf(product[1]))) {
            System.out.println("Incorrect record duration. Please reenter.");
            Scanner in = new Scanner(System.in);
            product[1] = in.next();
        }

        this.recDuration = Integer.valueOf(product[1]);
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Gadget gadget = (Gadget) o;
        return Objects.equals(price, gadget.price);
    }

    public void setPrice(Integer price) {
        this.price = price;
    }

    public Integer getPrice() {
        return price;
    }

    public Integer getCount() {
        return count;
    }

    public void setCount(Integer count) {
        while (!isCorrectCount(count)) {
            System.out.println("Incorrect quantity. Please reenter.");
            Scanner in = new Scanner(System.in);
            count = in.nextInt();
        }

        this.count = count;
    }

    private boolean isCorrectPrice(Integer price) {
        return price >= 0;
    }

    private boolean isCorrectCount(Integer count) {
        return count >= 0;
    }

    private boolean isCorrectRecDuration(Integer recDuration) {
        return recDuration > 0;
    }

    protected Integer getRecDuration() {
        return recDuration;
    }

    public abstract void print();
}
