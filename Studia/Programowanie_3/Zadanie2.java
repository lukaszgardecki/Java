import java.io.FileInputStream;
import java.io.IOException;
import java.io.InputStream;
import java.util.Properties;

public class Zadanie2 {

    public static void main(String[] args) {
        Konfiguracja config = Konfiguracja.getInstance();
        config.setTrybDebug(true);
        config.setSciezkaDoPliku("jakas/sciezka.properties");
        config.setWersja("2.0.0");

        System.out.println("\n>>> Wartości ustawionej konfiguracji:");
        System.out.println(config);

        innyFragmentAplikacji();

        System.out.println("\n>>> Wczytanie z pliku:");
        config.wczytajZPliku("plik.properties");

        System.out.println("\nAktualny stan po wczytaniu pliku:");
        System.out.println(Konfiguracja.getInstance());
    }

    private static void innyFragmentAplikacji() {
        Konfiguracja config = Konfiguracja.getInstance();
        System.out.println("\n>>> Konfiguracja odczytana z innego miejsca programu:");
        System.out.println(config);
    }
}

class Konfiguracja {
    private static volatile Konfiguracja instance;
    private boolean trybDebug;
    private String sciezkaDoPliku;
    private String wersja;

    private Konfiguracja() {
        this.trybDebug = false;
        this.sciezkaDoPliku = "default.properties";
        this.wersja = "1.0.0";
    }

    public static Konfiguracja getInstance() {
        if (instance == null) {
            synchronized (Konfiguracja.class) {
                if (instance == null) {
                    instance = new Konfiguracja();
                }
            }
        }
        return instance;
    }

    public void wczytajZPliku(String sciezka) {
        Properties props = new Properties();
        try (InputStream input = new FileInputStream(sciezka)) {
            props.load(input);

            if (props.containsKey("trybDebug")) {
                this.trybDebug = Boolean.parseBoolean(props.getProperty("trybDebug"));
            }
            if (props.containsKey("sciezkaDoPliku")) {
                this.sciezkaDoPliku = props.getProperty("sciezkaDoPliku");
            }
            if (props.containsKey("wersja")) {
                this.wersja = props.getProperty("wersja");
            }

            System.out.println("Pomyślnie wczytano konfigurację z pliku: " + sciezka);
        } catch (IOException e) {
            System.err.println("Nie udało się wczytać pliku: " + e.getMessage());
        }
    }

    public boolean isTrybDebug() { return trybDebug; }
    public void setTrybDebug(boolean trybDebug) { this.trybDebug = trybDebug; }
    public String getSciezkaDoPliku() { return sciezkaDoPliku; }
    public void setSciezkaDoPliku(String sciezkaDoPliku) { this.sciezkaDoPliku = sciezkaDoPliku; }
    public String getWersja() { return wersja; }
    public void setWersja(String wersja) { this.wersja = wersja; }

    @Override
    public String toString() {
        return "Konfiguracja {" +
                "trybDebug=" + trybDebug +
                ", sciezkaDoPliku='" + sciezkaDoPliku + '\'' +
                ", wersja='" + wersja + '\'' +
                '}';
    }
}
