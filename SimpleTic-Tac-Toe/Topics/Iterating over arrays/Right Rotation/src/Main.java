import java.util.*;

class Main {


    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        String[] tablica = scanner.nextLine().split(" ");
        int k = scanner.nextInt();

        //stworzenie tablicy int�w, nie mo�e to by� typ prymitywny int tylko musi by� Integer
        Integer[] liczby = new Integer[tablica.length];

        //dodanie wszystkich element�w tablicy stringowej do tablicy intowej
        for (int i = 0; i < tablica.length; i++) {
            liczby[i] = Integer.parseInt(tablica[i]);
        }
        //zamiana tablicy liczby NA LIST�.
        List<Integer> lista = new ArrayList<Integer>(Arrays.asList(liczby));

        //obr�t listy w prawo o k element�w:
        Collections.rotate(lista, k);

        //wy�wietlenei wszystkich element�w listy
        for (Integer i : lista) {
            System.out.print(i + " ");
        }




    }

}