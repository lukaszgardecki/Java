package wzorce.behawioralne.obserwator.Zadanie3.nadawcy;

import wzorce.behawioralne.obserwator.Zadanie3.obserwatorzy.Obserwator;

public interface Podmiot {
    void dodajObserwatora(Obserwator obserwator);
    void usunObserwatora(Obserwator obserwator);
    void powiadomObserwatorow();
}
