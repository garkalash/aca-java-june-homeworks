package com.aca.streams.exercises;

import com.aca.streams.models.City;
import com.aca.streams.models.Country;
import com.aca.streams.persistance.CityDao;
import com.aca.streams.persistance.CountryDao;
import com.aca.streams.persistance.InMemoryWorldDao;

import java.util.*;
import java.util.stream.Collectors;

/**
 * Find the highest populated capital city of each continent
 * you should collect <Continent, City> map
 *
 * @author: garik
 * @created: 7/29/2020, 2:41 PM
 */
public class ExerciseOfDev {
    public static void main(String[] args) {
        System.out.println(sortCountriesByCapitalsPopulation_Narek());
    }

    public static Map<String, City> sortCountriesByCapitalsPopulation_Narek() {
        CountryDao countryDao = InMemoryWorldDao.getInstance();
        Map<String, City> continentsHighestCapitals = new HashMap<>();

        CityDao cityDao = InMemoryWorldDao.getInstance();

        countryDao.getAllContinents().forEach(continent -> {
                    Optional<City> optionalCity = countryDao.findAllCountries().parallelStream()
                            .filter(Objects::nonNull)
                            .filter(country -> country.getContinent().equals(continent))
                            .map(country -> cityDao.findCityById(country.getCapital()))
                            .filter(Objects::nonNull)
                            .max(Comparator.comparingInt(city -> city.getPopulation()));
                    if (optionalCity.isPresent()) {
                        continentsHighestCapitals.put(continent, optionalCity.get());
                    }
                }
        );

        return continentsHighestCapitals;
    }
}
