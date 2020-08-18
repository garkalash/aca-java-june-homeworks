package com.aca.armine.multithreading;

public class Buyer {

    private String genre;
    private Integer count;

    public Buyer(String genre, Integer count) {
        this.genre = genre;
        if (count > 5) {
            this.count = 5;
        } else
            this.count = count;
    }

    public String getGenre() {
        return genre;
    }

    public void setGenre(String genre) {
        this.genre = genre;
    }

    public Integer getCount() {
        return count;
    }

    public void setCount(Integer count) {
        this.count = count;
    }
}
