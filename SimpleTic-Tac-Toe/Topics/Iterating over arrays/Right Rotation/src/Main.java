import java.util.*;

class Main {


    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        String[] tablica = scanner.nextLine().split(" ");
        int k = scanner.nextInt();

        //stworzenie tablicy intów, nie mo¿e to byæ typ prymitywny int tylko musi byæ Integer
        Integer[] liczby = new Integer[tablica.length];

        //dodanie wszystkich elementów tablicy stringowej do tablicy intowej
        for (int i = 0; i < tablica.length; i++) {
            liczby[i] = Integer.parseInt(tablica[i]);
        }
        //zamiana tablicy liczby NA LISTÊ.
        List<Integer> lista = new ArrayList<Integer>(Arrays.asList(liczby));

        //obrót listy w prawo o k elementów:
        Collections.rotate(lista, k);

        //wyœwietlenei wszystkich elementów listy
        for (Integer i : lista) {
            System.out.print(i + " ");
        }




    }

}