package com.example.listycity;

/**
 * This is a class that defines a City.
 */
public class City implements Comparable<City>{
    /**
     * City name
     */
    private String city;

    /**
     * Province name where city is located
     */
    private String province;

    /**
     * Constructs a new City object with a specified name and province.
     * * @param city     The name of the city.
     * @param province The name of the province.
     */
    City(String city, String province){
        this.city = city;
        this.province = province;
    }

    /**
     * Returns the name of the city.
     * * @return A string representing the city's name.
     */
    String getCityName(){
        return this.city;
    }

    /**
     * Returns the name of the province.
     * * @return A string representing the province's name.
     */
    String getProvinceName(){
        return this.province;
    }

    /**
     * Compares this city to another city by their names.
     * @param o The city to be compared.
     * @return a negative integer, zero, or a positive integer as this city
     * name is less than, equal to, or greater than the specified city name.
     */
    @Override
    public int compareTo(City o) {
        return this.city.compareTo(o.getCityName());
    }
}