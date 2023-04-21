package wzorce.obserwator.obserwatorzy;

public interface Obserwator {
    void aktualizacja(float temp, float wilgotność, float ciśnienie);
}
