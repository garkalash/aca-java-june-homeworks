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

    public Map<String, City> getHighestPopulatedCapitalByContinent_Armine() {
        CountryDao countryDao = InMemoryWorldDao.getInstance();
        CityDao cityDao = InMemoryWorldDao.getInstance();
        Set<String> continents = countryDao.getAllContinents();
        Map<String, City> continentsMap = new HashMap<>();
        for (String continent : continents) {
            Optional<City> optionalCity = countryDao.findAllCountries().parallelStream()
                    .filter(Objects::nonNull)
                    .filter(country -> country.getContinent().equals(continent))
                    .map(country -> cityDao.findCityById(country.getCapital()))
                    .filter(Objects::nonNull)
                    .max(Comparator.comparingInt(City::getPopulation));
            optionalCity.ifPresent(city -> continentsMap.put(continent, city));
        }
        return continentsMap;
    }


}
