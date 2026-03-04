package com.example.listycity;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

/**
 * This is a class that keeps track of a list of city objects.
 */
public class CityList {
    private List<City> cities = new ArrayList<>();

    /**
     * This adds a city to the list if the city does not exist.
     * @param city This is a candidate city to add.
     * @throws IllegalArgumentException if the city already exists in the list.
     */
    public void add(City city) {
        if (cities.contains(city)) {
            throw new IllegalArgumentException();
        }
        cities.add(city);
    }

    /**
     * This checks if a city is present in the list.
     * @param city The city to check for.
     * @return Boolean true if the city exists, false otherwise.
     */
    public boolean hasCity(City city) {
        return cities.contains(city);
    }

    /**
     * This removes a city from the list if it exists.
     * @param city The city to remove.
     * @throws IllegalArgumentException if the city is not in the list.
     */
    public void delete(City city) {
        if (!cities.contains(city)) {
            throw new IllegalArgumentException("City not found in the list");
        }
        cities.remove(city);
    }

    /**
     * This returns the total count of cities in the list.
     * @return Integer representing the size of the list.
     */
    public int countCities() {
        return cities.size();
    }

    /**
     * This returns a sorted list of cities.
     * It creates a copy of the list to avoid modifying the original data.
     * @return A sorted list of cities.
     */
    public List<City> getCities() {
        List<City> list = new ArrayList<>(cities); // Create a copy
        Collections.sort(list); // Requires City to implement Comparable
        return list;
    }
}