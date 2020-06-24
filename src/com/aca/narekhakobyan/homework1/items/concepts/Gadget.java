package com.aca.narekhakobyan.homework1.items.concepts;

import java.util.Objects;
import java.util.Scanner;

public abstract class Gadget {
    private final String name;
    private Integer price;
    private Integer count;

    protected Gadget(String name, Integer price, Integer count) {
        this.name = name;

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

    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Gadget gadget = (Gadget) o;
        return Objects.equals(name, gadget.name) &&
                Objects.equals(price, gadget.price);
    }

    public void setPrice(Integer price) {
        this.price = price;
    }

    public String getName() {
        return name;
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

    public abstract void print();
}
