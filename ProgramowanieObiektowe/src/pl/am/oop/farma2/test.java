package pl.am.oop.farma2;

public class test {
    public static void main(String[] args) {

        Zwierze[] zwierzeta = new Zwierze[4];
        zwierzeta[0] = new Pies("Reksio",15);
        zwierzeta[1] = new Kot("Kitek", 3);
        zwierzeta[2] = new Kura(1);
        zwierzeta[3] = new Krowa(200);

        //zwyk³a pêtla for:
//        for (int i = 0; i < zwierzeta.length; i++) {
//            zwierzeta[i].dajGlos();
//        }

        //For each. rozszerzona wersja pêtli for. Przechodzi przez wszystkie elementy tablicy.
        for (Zwierze zwierze : zwierzeta) {
            zwierze.dajGlos();
        }


    }
}
