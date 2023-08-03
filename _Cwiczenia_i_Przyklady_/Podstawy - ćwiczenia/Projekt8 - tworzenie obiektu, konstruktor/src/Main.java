public class Main {
    public static void main(String[] args) {

        //Dodajemy nowy obiekt o nazwie Jan, nadajemy mu imię Jan (w bardziej właściwy sposób):
        Czlowiek Jan = new Czlowiek("Jan");

        //Nadanie imienia ręcznie, tj. w mniej właściwy sposób
        //Jan.imie = "Jan";

        System.out.println(Jan.imie);
        System.out.println(Czlowiek.liczebnosc);

        Czlowiek Daniel = new Czlowiek();
        //nadanie imienia ręcznie, tj. w mniej właściwy sposób:
        Daniel.imie = "Daniel";
        System.out.println(Czlowiek.liczebnosc);


    }
}
