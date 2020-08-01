package com.aca.streams.exercises;

import com.aca.streams.models.Country;
import com.aca.streams.persistance.CountryDao;
import com.aca.streams.persistance.InMemoryWorldDao;

import java.util.List;
import java.util.Objects;
import java.util.stream.Collectors;

/**
 * Sort the countries by their population densities in descending order ignoring zero population countries
 *
 * @author: garik
 * @created: 7/28/2020, 6:22 PM
 */
public class Exercise4 {
    public static void main(String[] args) {
        System.out.println(sortCountriesByPopulation_Narek());
    }

    public static List<Country> sortCountriesByPopulation_Narek() {
        CountryDao countryDao = InMemoryWorldDao.getInstance();

        return countryDao.findAllCountries().stream()
                .filter(Objects::nonNull)
                .filter(country -> country.getPopulation() != 0)
                .sorted((country1, country2) -> country1.getSurfaceArea() == 0 && country2.getSurfaceArea() == 0 ? 0 :
                                                country1.getSurfaceArea() == 0 ? -1 : country2.getSurfaceArea() == 0 ? 1 :
                                                country1.getPopulation()/country1.getSurfaceArea() == country2.getPopulation()/country2.getSurfaceArea() ? 0 :
                                                country1.getPopulation()/country1.getSurfaceArea() < country2.getPopulation()/country2.getSurfaceArea() ? 1 : -1)
                .collect(Collectors.toList());
    }
}
