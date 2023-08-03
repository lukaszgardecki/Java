package Dom;

public class Telewizor {
    private String marka;
    private String model;
    private String kolor;
    private int iloscCali;

    public Telewizor() {

    }

    public Telewizor(String marka, String model, String kolor, int iloscCali) {
        this.marka = marka;
        this.model = model;
        this.kolor = kolor;
        this.iloscCali = iloscCali;
    }

    public void jestWlaczony() {
        System.out.println("Dom.Telewizor " + getMarka() + " jest w³¹czony!");
    }

    public void jestWylaczony() {
        System.out.println("Dom.Telewizor " + getMarka() + " jest wy³¹czony!");
    }





    public String getMarka() {
        return marka;
    }
    public String getModel() {
        return model;
    }
    public String getKolor() {
        return kolor;
    }
    public int getIloscCali() {
        return iloscCali;
    }

    public void setMarka(String marka) {
        this.marka = marka;
    }
    public void setModel(String model) {
        this.model = model;
    }
    public void setKolor(String kolor) {
        this.kolor = kolor;
    }
    public void setIloscCali(int iloscCali) {
        this.iloscCali = iloscCali;
    }

}
