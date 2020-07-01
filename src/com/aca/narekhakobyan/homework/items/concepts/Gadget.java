package com.aca.narekhakobyan.homework.items.concepts;

import sun.rmi.runtime.Log;

import java.io.IOException;
import java.util.Objects;
import java.util.Scanner;
import java.util.logging.FileHandler;
import java.util.logging.Logger;

public abstract class Gadget implements Cloneable {
    private Integer price;
    private Integer count;
    private Integer recDuration;
    private String name;

    @Override
    public Object clone() throws CloneNotSupportedException {
        return super.clone();
    }

    protected Gadget(Integer recDuration, Integer price, Integer count) {

        this.price = price;

        this.count = count;

        this.recDuration = recDuration;
    }

    private void setName(String name) {
        this.name = name;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Gadget gadget = (Gadget) o;
        return Objects.equals(price, gadget.price);
    }

    public void setPrice(Integer price) {
        if (!isCorrectPrice(price)) {
            Logger logger = Logger.getLogger("Errors");
            FileHandler errorsLog = null;
            try {
                errorsLog = new FileHandler("src\\com\\aca\\narekhakobyan\\homework\\errors\\errors.log", true);
                logger.addHandler(errorsLog);
                logger.severe("Incorrect price for " + this.name);
            }
            catch (IOException e){
                e.printStackTrace();
            }
        }

        this.price = price;
    }

    public Integer getPrice() {
        return price;
    }

    public Integer getCount() {
        return count;
    }

    public void setCount(Integer count) {
       if (!isCorrectCount(count)) {
           Logger logger = Logger.getLogger("Errors");
           FileHandler errorsLog = null;
           try {
               errorsLog = new FileHandler("src\\com\\aca\\narekhakobyan\\homework\\errors\\errors.log", true);
               logger.addHandler(errorsLog);
               logger.severe("Incorrect count for " + this.name);
           }
           catch (IOException e){
               e.printStackTrace();
           }
        }

        this.count = count;
    }

    public void setRecDuration(Integer recDuration) {
        if (!isCorrectRecDuration(recDuration)) {
            Logger logger = Logger.getLogger("Errors");
            FileHandler errorsLog = null;
            try {
                errorsLog = new FileHandler("src\\com\\aca\\narekhakobyan\\homework\\errors\\errors.log", true);
                logger.addHandler(errorsLog);
                logger.severe("Incorrect record duration for " + this.name);
            }
            catch (IOException e){
                e.printStackTrace();
            }
        }

        this.recDuration = recDuration;
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

    public Integer getRecDuration() {
        return recDuration;
    }

    public String getName() {
        return name;
    }

    public abstract void print(String path);
}
