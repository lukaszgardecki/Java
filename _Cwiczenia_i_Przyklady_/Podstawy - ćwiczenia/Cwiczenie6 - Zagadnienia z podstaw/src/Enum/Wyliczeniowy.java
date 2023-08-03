package Enum;

public class Wyliczeniowy {

    //Enum jest to klasa, która ma ograniczon¹ liczbê mo¿liwych obiektów
    public enum DzienTygodnia {
        PONIEDZIALEK(1, "pon"),
        WTOREK(2, "wt"),
        SRODA(3, "sr"),
        CZWARTEK(4, "czw"),
        PIATEK(5, "pt"),
        SOBOTA(6, "sob"),
        NIEDZIELA(7, "nd");

        private int numer;
        private String skrot;

        private DzienTygodnia(int n, String s) {
            numer = n;
            skrot = s;
        }

        public String toString() {
            return numer + " dzieñ tygodnia: " + super.toString() + ", skrót: " + skrot;
        }

        public void komentuj() {
            if (this == DzienTygodnia.NIEDZIELA) {
                System.out.println("Jak niedziela to niedziela");
            } else if (this == DzienTygodnia.PONIEDZIALEK) {
                System.out.println("Oniieieeeeee");
            }
        }
    }


    public static void main(String[] args) {
        DzienTygodnia dzisiaj = DzienTygodnia.NIEDZIELA;
        DzienTygodnia popo = DzienTygodnia.PONIEDZIALEK;

        popo.komentuj();
        dzisiaj.komentuj();


//        for (DzienTygodnia d : DzienTygodnia.values()) {
//            System.out.println(d.toString());
//        }
    }
}
