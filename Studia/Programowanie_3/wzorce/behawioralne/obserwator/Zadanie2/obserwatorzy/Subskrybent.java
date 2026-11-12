package wzorce.behawioralne.obserwator.Zadanie2.obserwatorzy;

public class Subskrybent implements Obserwator {
    private String nazwa;

    public Subskrybent(String nazwa) {
        this.nazwa = nazwa;
    }

    @Override
    public void powiadomONowymFilmie(String tytul) {
        System.out.printf("%s otrzymał powiadomienie o filmie: %s\n", nazwa, tytul);
    }
}
