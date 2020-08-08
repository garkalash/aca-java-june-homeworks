package com.aca.naresilanyan.streamHomework;

import java.util.*;
import java.util.function.Consumer;

public class streamAPI {
    public static void main(String[] args) {
//   1.     Strings
        String stringTest = string(Arrays.asList(1,2,3,4));
        System.out.println(stringTest);


//   3.   Get the highest populated city of each country


        Country country = new Country("us", "United States", "North America", 328,9833520, 20.84,"Washington");
        Country country2 = new Country("de", "Germany", "Europe", 83,357022, 4.5,"Berlin");


        country.setCities(Arrays.asList(
                new City(2,"Chicago", "us",2695598),
                new City(10,"New York", "us",8175133),
                new City(3,"Los Angeles","us", 379621)
        ));

        country2.setCities(Arrays.asList(
                new City(4,"Humburg", "de",1787000),
                new City(6,"Munich", "de",1450000),
                new City(7,"Berlin","de", 3520000)

        ));
        List<Country> countries = Arrays.asList(country, country2);

        Map<String, String> countryCityMap= new HashMap<>();


        countries.stream().forEach(country1 -> {
           String cityName = country1.getCities().stream().max((o1,o2)-> o1.getPopulation()-o2.getPopulation()).stream().findFirst().get().getName();
           countryCityMap.put(country1.getName(),cityName);
        });

        System.out.println(countryCityMap);




    }

    static String string(List<Integer> integer){
        List<String> strings = new ArrayList<>();
        integer.forEach(integer1 -> {
            if (integer1 % 2 == 0) {
                strings.add("e" + integer1);
            }else {
            strings.add("o"+integer1);
            }
        });

        return strings.toString();
    }
}

 class Country {
    private String code;
    private String name;
    private String continent;
    private double surfaceArea;
    private int population;
    private double gnp;
    private String capital;
    private List<City> cities;
    {
        cities = new ArrayList<>();
    }

    public Country() {
    }

    public Country(String code, String name, String continent, int population,
                   double surfaceArea, double gnp, String capital) {
        this.code = code;
        this.name = name;
        this.continent = continent;
        this.population = population;
        this.surfaceArea = surfaceArea;
        this.gnp = gnp;
        this.capital = capital;

    }


    // getters and setters


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

     public String getContinent() {
         return continent;
     }

     public void setContinent(String continent) {
         this.continent = continent;
     }

     public double getSurfaceArea() {
         return surfaceArea;
     }

     public void setSurfaceArea(double surfaceArea) {
         this.surfaceArea = surfaceArea;
     }

     public int getPopulation() {
         return population;
     }

     public void setPopulation(int population) {
         this.population = population;
     }

     public double getGnp() {
         return gnp;
     }

     public void setGnp(double gnp) {
         this.gnp = gnp;
     }

     public String getCapital() {
         return capital;
     }

     public void setCapital(String capital) {
         this.capital = capital;
     }

     public List<City> getCities() {
         return cities;
     }

     public void setCities(List<City> cities) {
         this.cities = cities;
     }

     @Override
    public String toString() {
        return "Country [ name=" + name + ", population=" + population + "]";
    }

}

 class City {
    private int id;
    private String name;
    private int population;
    private String countryCode;

    public City() {
    }

    public City(int id, String name, String countryCode, int population) {
        this.id = id;
        this.name = name;
        this.population = population;
        this.countryCode = countryCode;
    }

    // getters and setters


     public int getId() {
         return id;
     }

     public void setId(int id) {
         this.id = id;
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

     public String getCountryCode() {
         return countryCode;
     }

     public void setCountryCode(String countryCode) {
         this.countryCode = countryCode;
     }

     @Override
    public String toString() {
        return "City [id=" + id + ", name=" + name + ", population=" + population + ", countryCode=" + countryCode + "]";
    };

}


