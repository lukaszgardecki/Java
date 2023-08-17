package wzorce.obserwator.obiektObserwowany;

import wzorce.obserwator.obserwatorzy.Obserwator;

public interface Podmiot {
    void zarejestrujObserwatora(Obserwator o);

    void usuńObserwatora(Obserwator o);

    void powiadomObserwatorów();
}
