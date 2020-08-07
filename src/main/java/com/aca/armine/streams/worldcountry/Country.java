package com.aca.armine.streams.worldcountry;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Comparator;
import java.util.List;

public class Country {
    private String code;
    private String name;
    private int population;
    private int capital;
    private List<City> cities = new ArrayList<>();

    public Country(String code, String name, int population, int capital) {
        this.code = code;
        this.name = name;
        this.population = population;
        this.capital = capital;
    }

    public void putCities(City... city) {
        cities.addAll(Arrays.asList(city));
    }

    public City getHighestPopulatedCity() {
        return cities.stream().max(Comparator.comparing(City::getPopulation)).get();

    }

    public String getCode() {
        return code;
    }

    public void setCode(String code) {
        this.code = code;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public int getPopulation() {
        return population;
    }

    public void setPopulation(int population) {
        this.population = population;
    }

    public int getCapital() {
        return capital;
    }

    public void setCapital(int capital) {
        this.capital = capital;
    }


    @Override
    public String toString() {
        return "Country [ name=" + name + ", population=" + population + "]";
    }

}

