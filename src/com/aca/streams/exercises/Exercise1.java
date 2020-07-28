package com.aca.streams.exercises;

import com.aca.streams.models.City;
import com.aca.streams.persistance.CountryDao;
import com.aca.streams.persistance.InMemoryWorldDao;

import java.util.Comparator;
import java.util.List;
import java.util.Optional;
import java.util.stream.Collectors;

/**
 * Find the highest populated city of each country
 *
 * @author: garik
 * @created 7/28/2020, 6:18 PM
 */
public class Exercise1 {
    public static void main(String[] args) {
        CountryDao countryDao= InMemoryWorldDao.getInstance();

        List<City> highPopulatedCitiesOfCountries = countryDao.findAllCountries()
                .stream()
                .map( country -> country.getCities().stream()
                        .max(Comparator.comparing(City::getPopulation)))
                .filter(Optional::isPresent)
                .map(Optional::get)
                .collect(Collectors.toList());

        highPopulatedCitiesOfCountries.forEach(System.out::println);
    }
}
