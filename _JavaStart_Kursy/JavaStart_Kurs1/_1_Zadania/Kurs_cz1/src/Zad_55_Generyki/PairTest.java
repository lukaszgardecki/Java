package Zad_55_Generyki;

class PairTest {
    public static void main(String[] args) {

        Pair<Integer, String> para1 = new Pair<>(35, "numer buta");
        Pair<Integer, String> para2 = new Pair<>(34, "numer buta obok");
        Pair<Integer, String> para3 = new Pair<>(27, "a to to nie wiem");

        para1.showInfo();
        para2.showInfo();
        para3.showInfo();

    }
}
