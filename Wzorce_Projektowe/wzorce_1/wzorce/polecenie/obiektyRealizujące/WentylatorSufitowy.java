package wzorce.polecenie.obiektyRealizujące;

public class WentylatorSufitowy {
    public static final int SZYBKO = 3;
    public static final int ŚREDNIO = 2;
    public static final int WOLNO = 1;
    public static final int WYŁĄCZ = 0;
    private String pokój;
    private int prędkość;

    public WentylatorSufitowy(String pokój) {
        this.pokój = pokój;
        prędkość = WYŁĄCZ;
    }

    public void włączWysokieObroty() {
        prędkość = SZYBKO;
        System.out.printf("%s wentylator sufitowy włączony - wysokie obroty.%n", pokój);
    }

    public void włączŚrednieObroty() {
        prędkość = ŚREDNIO;
        System.out.printf("%s wentylator sufitowy włączony - średnie obroty.%n", pokój);
    }

    public void włączNiskieObroty() {
        prędkość = WOLNO;
        System.out.printf("%s wentylator sufitowy włączony - niskie obroty.%n", pokój);
    }

    public void wyłącz() {
        prędkość = WYŁĄCZ;
        System.out.printf("%s wentylator sufitowy wyłączony.%n", pokój);
    }

    public int pobierzPrędkość() {
        return prędkość;
    }
}
