package com.aca.streams.exercises;

import com.aca.streams.models.City;
import com.aca.streams.models.Country;
import com.aca.streams.persistance.CityDao;
import com.aca.streams.persistance.CountryDao;
import com.aca.streams.persistance.InMemoryWorldDao;
import java.util.*;

/**
 * Find the highest populated capital city of each continent
 * you should collect <Continent, City> map
 *
 * @author: garik
 * @created: 7/29/2020, 2:41 PM
 */
public class ExerciseOfDev {
    public static void main(String[] args) {

    }

    private Map<String, City> highestPopCitiesOfContinents_Arsen ()
    {
        CountryDao countryDao = InMemoryWorldDao.getInstance();
        CityDao cityDao = InMemoryWorldDao.getInstance();
        Map<String, City> highestPopulatedCapitals = new HashMap<>();
        for (String continent : countryDao.getAllContinents()) {
            Optional<City> optionalCity = countryDao.findAllCountries()
                    .stream()
                    .filter(Objects::nonNull)
                    .filter(country -> country.getContinent().equals(continent))
                    .map(country -> cityDao.findCityById(country.getCapital()))
                    .filter(Objects::nonNull)
                    .max(Comparator.comparingInt(City::getPopulation));
            optionalCity.ifPresent(city -> highestPopulatedCapitals.put(continent, optionalCity.get()));
        }
        return highestPopulatedCapitals;
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
