package com.example.listycity;

import org.junit.Test;

import static org.junit.Assert.*;

public class CityListTest {

    private CityList emptyCityList() {
        return new CityList();
    }

    private CityList cityListWithEdmonton() {
        CityList cityList = new CityList();
        cityList.add(new City("Edmonton", "Alberta"));
        return cityList;
    }

    @Test
    public void hasCity_emptyList_returnsFalse() {
        CityList cityList = emptyCityList();
        assertFalse(cityList.hasCity(new City("Edmonton", "Alberta")));
    }

    @Test
    public void hasCity_afterAdd_sameContentDifferentObject_returnsTrue() {
        CityList cityList = emptyCityList();
        cityList.add(new City("Edmonton", "Alberta"));
        assertTrue(cityList.hasCity(new City("Edmonton", "Alberta")));
    }

    @Test
    public void delete_existingCity_removesIt() {
        CityList cityList = cityListWithEdmonton();
        assertEquals(1, cityList.countCities());

        cityList.delete(new City("Edmonton", "Alberta"));

        assertEquals(0, cityList.countCities());
        assertFalse(cityList.hasCity(new City("Edmonton", "Alberta")));
    }

    @Test(expected = IllegalArgumentException.class)
    public void delete_missingCity_throwsException() {
        CityList cityList = emptyCityList();
        cityList.delete(new City("Calgary", "Alberta"));
    }

    @Test
    public void countCities_tracksAddsAndDeletes() {
        CityList cityList = emptyCityList();
        assertEquals(0, cityList.countCities());

        cityList.add(new City("Edmonton", "Alberta"));
        cityList.add(new City("Calgary", "Alberta"));
        assertEquals(2, cityList.countCities());

        cityList.delete(new City("Edmonton", "Alberta"));
        assertEquals(1, cityList.countCities());
    }
}