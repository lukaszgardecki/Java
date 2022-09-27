package Java_poziom_1.Lekcja_9_przetwarzanie_danych_napisy_i_liczby.przyklad_1;

class QTimer {
    private final long start;

    public QTimer() {
        System.gc();
        start = System.currentTimeMillis();
    }

    public long getElapsed() {
        return System.currentTimeMillis() - start;
    }
}
