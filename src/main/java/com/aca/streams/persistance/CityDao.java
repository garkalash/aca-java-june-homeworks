package com.aca.streams.persistance;

import com.aca.streams.models.City;

import java.util.List;


/**
 *
 * @author garik
 */
public interface CityDao {
	City findCityById(int id);

	City removeCity(City city);

	City addCity(City city);

	City updateCity(City city);

	List<City> findAllCities();

	List<City> findCitiesByCountryCode(String countryCode);
}
