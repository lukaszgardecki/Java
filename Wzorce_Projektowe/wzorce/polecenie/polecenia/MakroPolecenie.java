package wzorce.polecenie.polecenia;

public class MakroPolecenie implements Polecenie {
    private Polecenie[] polecenia;

    public MakroPolecenie(Polecenie[] polecenia) {
        this.polecenia = polecenia;
    }

    @Override
    public void wykonaj() {
        for (int i = 0; i < polecenia.length; i++) {
            polecenia[i].wykonaj();
        }
    }

    @Override
    public void wycofaj() {
        for (int i = polecenia.length-1; i >= 0; i--) {
            polecenia[i].wycofaj();
        }
    }
}
