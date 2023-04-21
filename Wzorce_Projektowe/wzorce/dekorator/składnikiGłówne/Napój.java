package wzorce.dekorator.składnikiGłówne;

public abstract class Napój {
    protected String opis = "Napój nieznany";
    protected int wielkość = 0;
    public static final int MAŁY = 1;
    public static final int ŚREDNI = 2;
    public static final int DUŻY = 3;

    public String pobierzOpis() {
        return opis;
    }

    public abstract double koszt();

    public void ustawWielkość(int wielkość) {
        this.wielkość = wielkość;
    }

    public int pobierzWielkość() {
        return wielkość;
    }
}
