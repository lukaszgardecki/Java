package Zad_22_TablicaDwuwymiarowa;

class Main {
    public static void main(String[] args) {
        double[][] liczby = new double[3][3];
        double sum1 = 0;
        double sum2 = 0;
        double sum3 = 0;

        double liczba = 1.0;
        for (int i = 0; i < liczby.length; i++) {
            for (int j = 0; j < liczby[i].length; j++) {
                liczby[i][j] = liczba;
                liczba += 0.5;
            }
            liczba -= 1.0;
        }

        sum1 = (liczby[0][0] * liczby[1][1] * liczby[2][2]) + (liczby[0][2] * liczby[1][1] * liczby[2][0]);
        sum2 = (liczby[1][0] + liczby[1][1] + liczby[1][2]) * (liczby[0][1] + liczby[1][1] + liczby[2][1]);
        sum3 = liczby[0][0] + liczby[0][1] + liczby[0][2] + liczby[1][0] + liczby[1][2] + liczby[2][0] + liczby[2][1] + liczby[2][2];

        System.out.println("Suma iloczynów przek¹tnych: " + sum1);
        System.out.println("Iloczyn sum œrodkowego wiersza i œrodkowej kolumny: " + sum2);
        System.out.println("Suma wszystkich elementów znajduj¹cych siê przy krawêdzi: " + sum3);
    }
}
