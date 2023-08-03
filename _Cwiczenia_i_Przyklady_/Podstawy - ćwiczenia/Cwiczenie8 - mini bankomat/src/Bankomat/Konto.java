package Bankomat;

public class Konto {
    private String numerKonta;
    private String numerKarty;
    private double saldo;
    private String PIN;
    private String imieWlasciciela;

    //Konstruktor:
    public Konto(String nrKonta, String nrKarty, String PIN, double stanKonta, String wlasciciel) {
        this.numerKonta = nrKonta;
        this.numerKarty = nrKarty;
        this.PIN = PIN;
        this.saldo = stanKonta;
        this.imieWlasciciela = wlasciciel;
    }

    public double wyplata(double kwotaWyplaty) {
        return saldo -= kwotaWyplaty;
    }

    public double wplata(double kwotaWplaty) {
        return saldo += kwotaWplaty;
    }





    public String getNumerKonta() {
        return numerKonta;
    }
    public String getNumerKarty() {
        return numerKarty;
    }
    public double getSaldo() {
        return saldo;
    }
    public String getImieWlasciciela() {
        return imieWlasciciela;
    }
    public String getPIN() {
        return PIN;
    }


    public void setNumerKonta(String numerKonta) {
        this.numerKonta = numerKonta;
    }
    public void setNumerKarty(String numerKarty) {
        this.numerKarty = numerKarty;
    }
    public void setSaldo(double saldo) {
        this.saldo = saldo;
    }
    public void setImieWlasciciela(String imieWlasciciela) {
        this.imieWlasciciela = imieWlasciciela;
    }
    public void setPIN(String PIN) {
        this.PIN = PIN;
    }
}
