package wzorce.metodaSzablonowa;

public class NapojeBarTest {
    public static void main(String[] args) {
        Herbata herbata = new Herbata();
        Kawa kawa = new Kawa();

        System.out.println("\nPrzyrządzam wspaniałą, gorącą herbatę...");
        herbata.recepturaParzenia();

        System.out.println("\nA teraz pora na gorącą, aromatyczną kawę...");
        kawa.recepturaParzenia();
    }
}
