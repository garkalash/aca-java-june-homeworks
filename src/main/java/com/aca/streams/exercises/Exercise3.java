package com.aca.streams.exercises;

import com.aca.streams.models.Country;
import com.aca.streams.persistance.CountryDao;
import com.aca.streams.persistance.InMemoryWorldDao;

import java.util.List;
import java.util.Objects;
import java.util.stream.Collectors;

/**
 * Sort the countries by number of their cities in descending order
 *
 * @author: garik
 * @created: 7/28/2020, 6:22 PM
 */
public class Exercise3 {
    public static void main(String[] args) {

    }

    public static List<Country> sortCountriesByNumberOfCities_Narek() {
        CountryDao countryDao = InMemoryWorldDao.getInstance();

        return countryDao.findAllCountries().stream()
                .filter(Objects::nonNull)
                .filter(country -> country.getCities() != null)
                .sorted((country1, country2) -> country2.getCities().size() - country1.getCities().size())
                .collect(Collectors.toList());
    }

    public List<Country> sortCountriesByNumberOfCities_Armine() {
        CountryDao countryDao = InMemoryWorldDao.getInstance();
        return countryDao.findAllCountries().stream()
                .filter(Objects::nonNull)
                .filter(country -> country.getCities() != null)
                .sorted((country1, country2) -> country2.getCities().size() - country1.getCities().size())
                .collect(Collectors.toList());
    }

}
