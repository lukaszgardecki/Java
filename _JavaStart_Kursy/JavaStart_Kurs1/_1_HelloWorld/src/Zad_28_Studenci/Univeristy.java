package Zad_28_Studenci;

class Univeristy {
    public static void main(String[] args) {
        new Student("Krzysztof", "Majeranek", "1234");
        new Student("Majonez", "Kielecki", "1360");

        System.out.println("Liczba studentów na uczelni to: " + Student.getNum());
    }
}
