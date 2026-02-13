package com.example.listycity;

import java.util.Objects;

/**
 * Represents a city identified by a city name and a province name.
 * <p>
 * City objects are comparable (for sorting) and are equal by value (city + province).
 */
public class City implements Comparable<City> {
    private String city;
    private String province;

    /**
     * Constructs a City.
     *
     * @param city the city name
     * @param province the province name
     */
    City(String city, String province){
        this.city = city;
        this.province = province;
    }

    /**
     * @return the city name
     */
    String getCityName(){
        return this.city;
    }

    /**
     * @return the province name
     */
    String getProvinceName() {
        return this.province;
    }

    /**
     * Compares cities for sorting. Primary key is city name; tie-breaker is province name.
     *
     * @param o the other city
     * @return comparison result
     */
    @Override
    public int compareTo(City o) {
        int byCity = this.city.compareTo(o.getCityName());
        if (byCity != 0) return byCity;
        return this.province.compareTo(o.getProvinceName());
    }

    /**
     * Value equality: two cities are equal if both city name and province name match.
     *
     * @param obj other object
     * @return true if equal by value
     */
    @Override
    public boolean equals(Object obj) {
        if (this == obj) return true;
        if (!(obj instanceof City)) return false;
        City other = (City) obj;
        return Objects.equals(city, other.city) && Objects.equals(province, other.province);
    }

    /**
     * Hash code consistent with {@link #equals(Object)}.
     *
     * @return hash code
     */
    @Override
    public int hashCode() {
        return Objects.hash(city, province);
    }
}