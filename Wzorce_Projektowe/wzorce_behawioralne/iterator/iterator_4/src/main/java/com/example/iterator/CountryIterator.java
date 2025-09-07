package com.example.iterator;

import java.util.Iterator;

public class CountryIterator implements Iterator<Country> {
    private final CountryCollection countryCollection;
    private int index;

    public CountryIterator(CountryCollection countryCollection) {
        this.countryCollection = countryCollection;
        this.index = 0;
    }

    @Override
    public boolean hasNext() {
        return index < countryCollection.getCountries().length;
    }

    @Override
    public Country next() {
        Country[] countryList = countryCollection.getCountries();
        if (hasNext()) {
            return countryList[index++];
        } else {
            return null;
        }
    }
}
