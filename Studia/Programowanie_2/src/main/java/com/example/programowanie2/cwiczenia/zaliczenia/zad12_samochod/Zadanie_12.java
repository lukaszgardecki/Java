package com.example.programowanie2.cwiczenia.zaliczenia.zad12_samochod;

class Samochod {
    private int vMax;
    private double paliwoWZbiorniku;
    private double zuzycieNa100km;

    Samochod() {
        this(100, 20.0, 5.6);
    }

    Samochod(int vMax, double paliwoWZbiorniku, double zuzycieNa100km) {
        setVMax(vMax);
        setPaliwoWZbiorniku(paliwoWZbiorniku);
        setZuzycieNa100km(zuzycieNa100km);
    }

    public int getVMax() {
        return vMax;
    }

    public void setVMax(int vMax) {
        if (vMax <= 0) throw new IllegalArgumentException("vMax musi być dodatnie!");
        this.vMax = vMax;
    }

    public double getPaliwoWZbiorniku() {
        return paliwoWZbiorniku;
    }

    public void setPaliwoWZbiorniku(double paliwoWZbiorniku) {
        if (paliwoWZbiorniku < 0) throw new IllegalArgumentException("Paliwo nie może być ujemne!");
        this.paliwoWZbiorniku = paliwoWZbiorniku;
    }

    public double getZuzycieNa100km() {
        return zuzycieNa100km;
    }

    public void setZuzycieNa100km(double zuzycieNa100km) {
        if (zuzycieNa100km <= 0) throw new IllegalArgumentException("Zużycie musi być dodatnie!");
        this.zuzycieNa100km = zuzycieNa100km;
    }

    double zasieg() {
        return paliwoWZbiorniku * 100 / zuzycieNa100km;
    }

    double czasDojazdu(double dystans) {
        if (dystans < 0) throw new IllegalArgumentException("Dystans nie może być ujemny!");
        double sredniaPredkosc = vMax * 0.75;
        return dystans * 60 / sredniaPredkosc;
    }

    void zatankuj(double ilePaliwaZatankowano) {
        if (ilePaliwaZatankowano < 0) throw new IllegalArgumentException("Nie można zatankować ujemnej ilości paliwa!");
        paliwoWZbiorniku += ilePaliwaZatankowano;
    }

    void trasa(double liczbaKilometrów) {
        if (liczbaKilometrów < 0) throw new IllegalArgumentException("Dystans nie może być ujemny!");
        double zuzytePaliwo = liczbaKilometrów * zuzycieNa100km / 100;
        if (zuzytePaliwo > paliwoWZbiorniku)
            throw new IllegalStateException("Brak paliwa!");
        paliwoWZbiorniku -= zuzytePaliwo;
    }
}
