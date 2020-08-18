package com.aca.armine.multithreading;


import java.util.concurrent.ConcurrentMap;

public class TicketProviderCompany  {
    private String name;
    private ConcurrentMap<String, Integer> films;

    public TicketProviderCompany(String name, ConcurrentMap<String, Integer> films) {
        this.name = name;
        this.films = films;
    }

    public ConcurrentMap<String, Integer> getFilms() {
        return films;
    }

    public String getName() {
        return name;
    }
}
