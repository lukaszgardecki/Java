package unit1;

import java.util.Arrays;
import java.util.Comparator;
import java.util.List;
import java.util.function.Predicate;

public class Unit1ExerciseSolutionJava8 {
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
        printConditionally(people, p -> true);

//        ----------- Step 3: Create a method that prints all people that have last name beginning with C -----------
        System.out.println("\nPrinting all persons with last name beginning with 'C':");
//        printLastNameBeginningWithC(people);
        printConditionally(people, p -> p.getLastName().startsWith("C"));

        System.out.println("\nPrinting all persons with first name beginning with 'C':");
        printConditionally(people, p -> p.getFirstName().startsWith("C"));

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

    public static void printConditionally(List<Person> people, Condition condition) {
        for (Person p : people) {
            if(condition.test(p)) System.out.println(p);
        }
    }
}