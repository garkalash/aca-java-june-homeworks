package com.aca.files.model;


public class Pair  {
    private Integer from;
    private Integer to;

    public Pair(Integer from, Integer to) {
        this.from = from;
        this.to = to;
    }

    public Integer getFrom() {
        return from;
    }

    public void setFrom(Integer from) {
        this.from = from;
    }

    public Integer getTo() {
        return to;
    }

    public void setTo(Integer to) {
        this.to = to;
    }
    @Override
   public String toString () {
        return getFrom().toString()+" - "+ getTo().toString();
    }
}
