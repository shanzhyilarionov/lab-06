package com.example.listycity;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

/**
 * Maintains a collection of {@link City} objects.
 */
public class CityList {
    private List<City> cities = new ArrayList<>();

    /**
     * Adds a city to the list.
     *
     * @param city the city to add
     * @throws IllegalArgumentException if the city is already present
     */
    public void add(City city) {
        if (cities.contains(city)) {
            throw new IllegalArgumentException();
        }
        cities.add(city);
    }

    /**
     * Checks whether a city is in the list.
     *
     * @param city the city to check
     * @return true if present; false otherwise
     */
    public boolean hasCity(City city) {
        return cities.contains(city);
    }

    /**
     * Deletes a city from the list.
     *
     * @param city the city to delete
     * @throws IllegalArgumentException if the city is not found
     */
    public void delete(City city) {
        boolean removed = cities.remove(city);
        if (!removed) {
            throw new IllegalArgumentException();
        }
    }

    /**
     * Counts the number of cities in the list.
     *
     * @return number of cities
     */
    public int countCities() {
        return cities.size();
    }

    /**
     * Returns a sorted copy of the cities in this list.
     *
     * @return sorted list copy
     */
    public List<City> getCities() {
        List<City> list = new ArrayList<>(cities);
        Collections.sort(list);
        return list;
    }
}