package wzorce.polecenie.obiektyRealizujące;

public class Światło {
    private String pokój;

    public Światło(String pokój) {
        this.pokój = pokój;
    }

    public void włącz() {
        System.out.printf("%s światło włączone.%n", pokój);
    }

    public void wyłącz() {
        System.out.printf("%s światło wyłączone.%n", pokój);
    }
}
