package wzorce.behawioralne.obserwator.Zadanie1.nadawcy;

import wzorce.behawioralne.obserwator.Zadanie1.obserwatorzy.Obserwator;

public interface Podmiot {
    void dodajObserwatora(Obserwator o);
    void usunObserwatora(Obserwator o);
    void powiadomObserwatorow();
}
