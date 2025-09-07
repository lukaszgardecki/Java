package com.example.iterator;

import java.util.Iterator;

public class CountryCollection implements Iterable<Country> {
    private final Country[] countries;

    public CountryCollection(Country... countries) {
        this.countries = countries;
    }

    @Override
    public Iterator<Country> iterator() {
        return new CountryIterator(this);
    }

    public Country[] getCountries() {
        return countries;
    }
}
