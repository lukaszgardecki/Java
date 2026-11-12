package wzorce.behawioralne.obserwator.Zadanie5.nadawcy;

import wzorce.behawioralne.obserwator.Zadanie5.obserwatorzy.Obserwator;

public interface Podmiot {
    void dodajObserwatora(Obserwator obserwator);
    void usunObserwatora(Obserwator obserwator);
    void powiadomObserwatorow(String wiadomosc);
}
