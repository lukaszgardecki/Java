package wzorce.metodaSzablonowa;

public class Kawa extends NapójZKofeiną{

    @Override
    void zaparzanie() {
        System.out.println("Zaparzanie i przesączanie kawy przez filtr.");
    }

    @Override
    void domieszanieDodatków() {
        System.out.println("Dodawanie cukru oraz mleka do smaku.");
    }
}
