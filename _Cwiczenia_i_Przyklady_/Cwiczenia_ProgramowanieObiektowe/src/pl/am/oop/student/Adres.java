package pl.am.oop.student;

public class Adres {
    private String kraj;
    private String miejscowosc;
    private String ulica;
    private int numerDomu;

    public Adres(String kraj, String miejscowosc, String ulica, int numerDomu) {
        this.kraj = kraj;
        this.miejscowosc = miejscowosc;
        this.ulica = ulica;
        this.numerDomu = numerDomu;
    }

    public String getKraj() {
        return kraj;
    }

    public void setKraj(String kraj) {
        this.kraj = kraj;
    }

    public String getMiejscowosc() {
        return miejscowosc;
    }

    public void setMiejscowosc(String miejscowosc) {
        this.miejscowosc = miejscowosc;
    }

    public String getUlica() {
        return ulica;
    }

    public void setUlica(String ulica) {
        this.ulica = ulica;
    }

    public int getNumerDomu() {
        return numerDomu;
    }

    public void setNumerDomu(int numerDomu) {
        this.numerDomu = numerDomu;
    }

    @Override
    public String toString() {
        return "Adres{" +
                "kraj='" + kraj + '\'' +
                ", miejscowosc='" + miejscowosc + '\'' +
                ", ulica='" + ulica + '\'' +
                ", numerDomu=" + numerDomu +
                '}';
    }
}
