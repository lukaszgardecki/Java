public class Main {
    public static void main(String[] args) {
        int tab[] = new int[9]; //tablica to zmienna przechowująca inne zmienne

        tab[0] = 6;
        tab[1] = 9;
        tab[2] = 2;
        tab[3] = 6;
        tab[4] = 4;
        tab[5] = 1;
        tab[6] = 0;
        tab[7] = 8;
        tab[8] = 6;
//      PĘTLA WERSJA 1:
        for (int i = 0; i < tab.length; i++) {
            System.out.println("Element tablicy = " + tab[i]);
        }

//      PĘTLA SPOSÓB 2 - wersja krótsza, pętla for each:
//        for (int i : tab) {
//            System.out.println("Element tablicy = " + i);
//        }
//        PĘTLA SPOSÓB 3:
        for(int x : tab) {
            System.out.println(x);
        }

//          Pętla While:
        int n = 10;
        while(n >= 0) {
            System.out.println("cokolwiek " + n);
            n--;
        }
//          Pętla Do While:
        do {
            System.out.println("tekst");
            n++;
        } while (n < 5);


        {
            System.out.println("koniec");
        }

        int table[][] = {{2, 3, 4},{1,2,3}};
        for (int i = 0; i < table.length; i++) {
            for (int j = 0; j < table[i].length; j++) {
                System.out.println(table[i][j]);
            }
        }

        for (int a = 5; a > 0; a--) {
            for (int b = 5; b < 10; b++) {
                System.out.println("Zmienna a = " + a + ", zmienna b = " + b);
            }
        }





    }
}
