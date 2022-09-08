package io.javabrains.unit3;

import io.javabrains.unit1.Person;

import java.util.Arrays;
import java.util.List;

public class CollectionIterationExample {
    public static void main(String[] args) {
        List<Person> people = Arrays.asList(
                new Person("Charles", "Dickens", 60),
                new Person("Lewis", "Carroll", 42),
                new Person("Thomas", "Carlyle", 51),
                new Person("Charlotte", "Bronte", 45),
                new Person("Matthew", "Arnold", 39)
        );

//        ----- VERSION 1:
        System.out.println("\nUsing for loop");
        for (int i = 0; i < people.size(); i++) {
            System.out.println(people.get(i));
        }
//        ----- VERSION 2:
        System.out.println("\nUsing for each loop");
        for (Person p : people) {
            System.out.println(p);
        }
//        ----- VERSION 3:
        System.out.println("\nUsing lambda for each loop");
        people.forEach(person -> System.out.println(person));

//        ----- VERSION 4:
        System.out.println("\nUsing method reference for each loop");
        people.forEach(System.out::println);






    }
}
