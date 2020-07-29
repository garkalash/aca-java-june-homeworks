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
        //implementation here
    }

    public List<Country> sortCountriesByPopulation_Armine() {
        CountryDao countryDao = InMemoryWorldDao.getInstance();
        return countryDao.findAllCountries().stream()
                .filter(Objects::nonNull)
                .filter(country -> country.getPopulation() != 0 || country.getSurfaceArea() !=0 )
                .sorted((country1, country2) -> (int) (country2.getPopulation()/country2.getSurfaceArea() - country1.getPopulation()/country1.getSurfaceArea()))
                .collect(Collectors.toList());
    }

}
