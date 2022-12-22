package pl.mojastrona.movieclub;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

@SpringBootApplication
public class MovieClubApplication {

    public static void main(String[] args) {
        SpringApplication.run(MovieClubApplication.class, args);
    }


    /**
     * Funkcjonalności, które można dodać do projektu:
     *
     *     możliwość edytowania filmów,
     *     możliwość edytowania kategorii,
     *     możliwość usuwania filmów,
     *     możliwość usuwania kategorii,
     *     system komentarzy do filmów z możliwością administracji i dodawania shadow banów,
     *     wyszukiwarka filmów,
     *     opcja zgłaszania błędów w opisach filmów,
     *     publiczny profil użytkownika, czyli możliwość podejrzenia, jakie filmy ocenił i skomentował dany użytkownik,
     *     administracja użytkownikami i możliwość blokowania kont,
     *     możliwość edycji profilu użytkownika (np. zmiana adresu email, czy hasła),
     *     wprowadzenie paginacji, czyli przy bardzo dużej liczbie filmów nie wyświetlamy wszystkich filmów na jednej stronie, tylko zamiast tego robimy podstrony typu /gatunek/Dramat?strona=2,
     *     aktywacja konta użytkownika po rejestracji przez email,
     *     możliwość dodawania filmów przez wszystkich użytkowników i zatwierdzanie ich przez redaktorów, lub administratorów.
     */
}
