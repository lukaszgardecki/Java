package com.example.iterator;

public class App {

    public static void main(String[] args) {

        var india = new Country("India");
        var poland = new Country("Poland");
        var nigeria = new Country("Nigeria");
        var canada = new Country("Canada");
        var argentina = new Country("Argentina");

        var countryCollection = new CountryCollection(india, poland, nigeria, canada, argentina);
        var iterator = new CountryIterator(countryCollection);

        while (iterator.hasNext()) {
            System.out.println(iterator.next().getName());
        }
    }

}
