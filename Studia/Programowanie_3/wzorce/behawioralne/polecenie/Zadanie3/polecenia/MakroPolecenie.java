package wzorce.behawioralne.polecenie.Zadanie3.polecenia;

import java.util.List;
import java.util.ListIterator;

public class MakroPolecenie implements Polecenie {
    private final List<Polecenie> polecenia;

    public MakroPolecenie(List<Polecenie> poelcenia) {
        this.polecenia = poelcenia;
    }

    @Override
    public void wykonaj() {
        polecenia.forEach(Polecenie::wykonaj);
    }

    @Override
    public void cofnij() {
        ListIterator<Polecenie> it = polecenia.listIterator(polecenia.size());
        while (it.hasPrevious()) {
            it.previous().cofnij();
        }
    }
}
