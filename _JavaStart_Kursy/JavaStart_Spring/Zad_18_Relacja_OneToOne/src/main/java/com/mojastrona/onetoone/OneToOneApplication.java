package com.mojastrona.onetoone;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.ConfigurableApplicationContext;

import java.util.Optional;

@SpringBootApplication
public class OneToOneApplication {

    public static void main(String[] args) {
        ConfigurableApplicationContext context = SpringApplication.run(OneToOneApplication.class, args);

        UserRepository userRepository = context.getBean(UserRepository.class);
        UserDetailsRepository userDetailsRepository = context.getBean(UserDetailsRepository.class);

        UserDetails userDetails = new UserDetails("Jan", "Kowalski", "Wrocław, 50-503, ul. Legnicka 32/16");
        User user = new User("johnkowal", "strongpassword1", "johnkowal@example.com", userDetails);

        userDetailsRepository.save(userDetails);
        userRepository.save(user);

        //odczytywanie informacji o użytkowniku:
        Optional<User> firstUser = userRepository.findById(1L);
        System.out.println("Informacje o pierwszym użytkowniku:");
        firstUser.ifPresent(System.out::println);
        System.out.println("Szczegóły pierwszego użytkownika:");
        firstUser.map(User::getUserDetails).ifPresent(System.out::println);

        System.out.println("Szczegóły pierwszego użytkownika pobrane z bazy:");
        Optional<UserDetails> firstDetails = userDetailsRepository.findById(1L);
        firstDetails.ifPresent(System.out::println);
        System.out.println("Użytkownik powiązany ze szczegółami:");
        firstDetails.map(UserDetails::getUser).ifPresent(System.out::println);
    }

}
