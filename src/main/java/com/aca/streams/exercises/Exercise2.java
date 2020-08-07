package com.aca.streams.exercises;

import com.aca.streams.models.Country;
import com.aca.streams.persistance.CountryDao;
import com.aca.streams.persistance.InMemoryWorldDao;

import java.util.List;
import java.util.Objects;
import java.util.stream.Collectors;

/**
 * Find the highest populated capital city
 *
 * @author: garik
 * @created: 7/28/2020, 6:21 PM
 */
public class Exercise2 {
    public static void main(String[] args) {
        System.out.print(sortCountriesByCapital_Narek());
    }

    public static List<Country> sortCountriesByCapital_Narek() {
        CountryDao countryDao = InMemoryWorldDao.getInstance();

        return countryDao.findAllCountries().stream()
                .filter(Objects::nonNull)
                .sorted((country1, country2) -> country2.getCapital() - country1.getCapital())
                .collect(Collectors.toList());
    }
}
