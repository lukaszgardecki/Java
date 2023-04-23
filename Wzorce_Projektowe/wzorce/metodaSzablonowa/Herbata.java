package wzorce.metodaSzablonowa;

public class Herbata extends NapójZKofeiną{

    @Override
    void zaparzanie() {
        System.out.println("Wkładanie torebki herbatyh do wrzątku.");
    }

    @Override
    void domieszanieDodatków() {
        System.out.println("Dodawanie cytryny.");
    }
}
