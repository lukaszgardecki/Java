package pl.am.oop.interfejsy;

public class Kot extends ZwierzeDomowe implements Comparable<Kot> {

    public Kot(String nazwa, double masa) {
        super(nazwa, masa);
    }

    @Override
    public void dajGlos() {
        System.out.println("Mia³ mia³");
    }

    @Override
    public String toString() {
        return "Kot{" +
                "nazwa='" + nazwa + '\'' +
                ", masa=" + masa +
                '}';
    }
//sortowanie po masie/nazwach:
    @Override
    public int compareTo(Kot kot) {

        return nazwa.compareTo(kot.nazwa);
    }

//    @Override
//    public int compareTo(Object o) {
//        // this < 0 --> -
//        // this = 0 --> 0
//        // this > 0 --> +
//        Kot kot = (Kot)o;
//        return Double.compare(this.masa, kot.masa);
//    }
}
