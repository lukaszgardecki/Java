package wzorce.metodaSzablonowa;

public abstract class NapójZKofeiną {

    // to jest metoda szablonowa: zawiera metody od kolejnych algorytmów
    final void recepturaParzenia() {
        gotowanieWody();
        zaparzanie();
        nalewanieDoFiliżanki();
        if (czyKlientChceDodatki()) {
            domieszanieDodatków();
        }

    }
    abstract void zaparzanie();
    abstract void domieszanieDodatków();
    void gotowanieWody() {
        System.out.println("Gotowanie wody.");
    }
    public void nalewanieDoFiliżanki() {
        System.out.println("Nalewanie do filiżanki.");
    }

    //metoda haczyk: klasy podrzędne MOGĄ ją przesłonić a nie muszą
    boolean czyKlientChceDodatki() {
        return true;
    }
}
