package pl.am.oop.student;

import java.time.LocalDate;

public class Student {
    private String imie;
    private String nazwisko;
    private Adres adresZamieszkania;
    private Adres adresZameldowania;
    //do przechowywania daty wystarczaj¹ca jest klasa LocalDate: (nie potrzeba tworzyæ w³asnej klasy)
    private LocalDate dataUrodzenia;

    public String getImie() {
        return imie;
    }

    public void setImie(String imie) {
        this.imie = imie;
    }

    public String getNazwisko() {
        return nazwisko;
    }

    public void setNazwisko(String nazwisko) {
        this.nazwisko = nazwisko;
    }

    public Adres getAdresZamieszkania() {
        return adresZamieszkania;
    }

    public void setAdresZamieszkania(Adres adresZamieszkania) {
        this.adresZamieszkania = adresZamieszkania;
    }

    public Adres getAdresZameldowania() {
        return adresZameldowania;
    }

    public void setAdresZameldowania(Adres adresZameldowania) {
        this.adresZameldowania = adresZameldowania;
    }

    public LocalDate getDataUrodzenia() {
        return dataUrodzenia;
    }

    public void setDataUrodzenia(LocalDate dataUrodzenia) {
        this.dataUrodzenia = dataUrodzenia;
    }

    @Override
    public String toString() {
        return "Student{" +
                "imie='" + imie + '\'' +
                ", nazwisko='" + nazwisko + '\'' +
                ", adresZamieszkania=" + adresZamieszkania +
                ", adresZameldowania=" + adresZameldowania +
                ", dataUrodzenia=" + dataUrodzenia +
                '}';
    }

    public static void main(String[] args) {
        Student student = new Student();
        student.setImie("Jan");
        student.setNazwisko("Kowalski");
        student.setAdresZameldowania(new Adres("Polska", "Radom", "Leœna", 76));

        LocalDate dataUrodzenia = LocalDate.of(1993, 3, 21);
        //na podstawie danych powy¿ej mo¿emy wyœwietliæ jaki to by³ dzieñ tygodnia:
        System.out.println(dataUrodzenia.getDayOfWeek());

        student.setDataUrodzenia(dataUrodzenia);

        System.out.println(student);

    }

}
