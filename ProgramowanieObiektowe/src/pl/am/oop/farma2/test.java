package pl.am.oop.farma2;

public class test {
    public static void main(String[] args) {
        Pies pies = new Pies("Reksio",15);
        Kot kot = new Kot("Kitek", 3);
        Kura kura = new Kura(1);
        Krowa krowa = new Krowa(200);

        pies.dajGlos();
        pies.podajLape();
        kot.dajGlos();
        kura.dajGlos();
        kura.zniesJajo();
        krowa.dajGlos();
        krowa.dajMleko();



    }
}
