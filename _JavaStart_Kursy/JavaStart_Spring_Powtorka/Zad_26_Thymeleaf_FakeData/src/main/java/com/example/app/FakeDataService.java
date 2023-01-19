package com.example.app;

import com.github.javafaker.Faker;
import org.springframework.stereotype.Service;

import java.util.*;
import java.util.function.Supplier;
import java.util.stream.Stream;

@Service
public class FakeDataService {
    private static final String HEADER_FIRST_NAME = "Imię";
    private static final String HEADER_LAST_NAME = "Nazwisko";
    private static final String HEADER_UNIVERSITY = "Uczelnia";
    private static final String HEADER_COUNTRY = "Kraj pochodzenia";


    public Map<String, List<String>> createData(int size, String language,
                               boolean firstName, boolean lastName,
                               boolean university, boolean country) {
        Faker faker = new Faker(new Locale(language));
        Map<String, List<String>> map = new LinkedHashMap<>();
        if (firstName) map.put(HEADER_FIRST_NAME, getList(size, faker.name()::firstName));
        if (lastName) map.put(HEADER_LAST_NAME, getList(size, faker.name()::lastName));
        if (university) map.put(HEADER_UNIVERSITY, getList(size, faker.university()::name));
        if (country) map.put(HEADER_COUNTRY, getList(size, faker.country()::name));
        return map;
    }

    private List<String> getList(int size, Supplier<String> supplier) {
        return Stream.generate(supplier)
                .limit(size)
                .toList();
    }


}
