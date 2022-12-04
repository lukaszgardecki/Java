package com.example.datagenerator;

import com.github.javafaker.Faker;
import org.springframework.stereotype.Service;

import java.util.*;
import java.util.function.Supplier;
import java.util.stream.Stream;

@Service
public class DataGeneratorService {
    private static final String HEADER_FIRST_NAME = "Imię";
    private static final String HEADER_LAST_NAME = "Nazwisko";
    private static final String HEADER_UNIVERSITY = "Uczelnia";
    private static final String HEADER_COUNTRY = "Kraj pochodzenia";

    Map<String, List<String>> generateFakeData(
                                int size,
                                String language,
                                boolean firstName,
                                boolean lastName,
                                boolean university,
                                boolean country) {

        Faker faker = new Faker(new Locale(language));
        Map<String, List<String>> data = new LinkedHashMap<>();
        if (firstName) {
            data.put(HEADER_FIRST_NAME, generateData(size, faker.name()::firstName));
        }
        if (lastName) {
            data.put(HEADER_LAST_NAME, generateData(size, faker.name()::lastName));
        }
        if (university) {
            data.put(HEADER_UNIVERSITY, generateData(size, faker.country()::name));
        }
        if (country) {
            data.put(HEADER_COUNTRY, generateData(size, faker.country()::name));
        }

        return data;
    }

    private List<String> generateData(int size, Supplier<String> supplier) {
        return Stream.generate(supplier)
                .limit(size)
                .toList();
    }


}
