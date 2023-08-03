package unit2;

import io.javabrains.unit1.Person;

import java.util.Arrays;
import java.util.Comparator;
import java.util.List;
import java.util.function.Consumer;
import java.util.function.Predicate;

public class StandardFunctionalInterfacesExample {
    public static void main(String[] args) {
        List<Person> people = Arrays.asList(
                new Person("Charles", "Dickens", 60),
                new Person("Lewis", "Carroll", 42),
                new Person("Thomas", "Carlyle", 51),
                new Person("Charlotte", "Bronte", 45),
                new Person("Matthew", "Arnold", 39)
        );

//        -------------------- Step 1: Sort list by last name --------------------
//        -------VERSION 1 (LAMBDA):
//        people.sort((p1, p2) -> p1.getLastName().compareTo(p2.getLastName()));

//        -------VERSION 2(METHOD REFERENCE):
        people.sort(Comparator.comparing(Person::getLastName));

//        -------------------- Step 2: Create a method that prints all elements in the list --------------------
        System.out.println("Printing all persons:");
//        printAll(people);
        performConditionally(people, p -> true, p -> System.out.println(p));

//        ----------- Step 3: Create a method that prints all people that have last name beginning with C -----------
        System.out.println("\nPrinting all persons with last name beginning with 'C':");
//        printLastNameBeginningWithC(people);
        performConditionally(people, p -> p.getLastName().startsWith("C"), p -> System.out.println(p));
//        performConditionally(people, p -> p.getLastName().startsWith("C"), System.out::println);

        System.out.println("\nPrinting all persons with first name beginning with 'C':");
        performConditionally(people, p -> p.getFirstName().startsWith("C"), p -> System.out.println(p.getFirstName()));

    }

//    public static void printAll(List<Person> people) {
////        -------VERSION 1 (LAMBDA):
////            people.forEach(prsn -> System.out.println(prsn));
//
////        -------VERSION 2 (METHOD REFERENCE):
////            people.forEach(System.out::println);
//    }

    public static void printLastNameBeginningWithC(List<Person> people) {
//        -------VERSION 1:
//        for (Person p : people) {
//            if(p.getLastName().startsWith("C")) System.out.println(p);
//        }

//        -------VERSION 2 (LAMBDA):
        people.forEach(prsn -> {
            if(prsn.getLastName().startsWith("C")) System.out.println(prsn);
        });
    }

    public static void performConditionally(List<Person> people, Predicate<Person> predicate, Consumer<Person> consumer) {
        for (Person p : people) {
            if(predicate.test(p)) consumer.accept(p);
        }
    }
}
