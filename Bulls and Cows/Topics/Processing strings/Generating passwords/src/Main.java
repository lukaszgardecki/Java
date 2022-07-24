import java.util.*;

/**
 * Generator hase³.
 * input format: "A B C N"
 *
 * A - minimalna liczba wielkich liter w haœle
 * B - minimalna liczba ma³ych liter w haœle
 * C - minimalna liczba cyfr w haœle
 * N - d³ugoœæ has³a
 */

public class Main {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        String[] tab = scanner.nextLine().split("\\s+");
        int nA = Integer.parseInt(tab[0]);
        int nB = Integer.parseInt(tab[1]);
        int nC = Integer.parseInt(tab[2]);
        int nN = Integer.parseInt(tab[3]);
        int sumABC = nA + nB + nC;
        int sub = nN - sumABC;
        ArrayList<String> listA = new ArrayList<>(nA);
        ArrayList<String> listB = new ArrayList<>(nB);
        ArrayList<String> listC = new ArrayList<>(nC);
        ArrayList<String> listSub = new ArrayList<>(nN);
                                                //ASCII:
        final int cd = 0, cg = 9;
        final int wld = 65, wlg = 90;           //Wielkie litery 65 - 90
        final int mld = 97, mlg = 122;          //Ma³e litery 97 - 122

        int cZ = cg - cd + 1;
        int wlZ = wlg - wld + 1;
        int mlZ = mlg - mld + 1;


        //dodawanie elementów do tablicy A
        while (listA.size() < nA) {
            if(listA.size() == 0) {
                char randChar = (char)(int) (Math.floor(Math.random() * wlZ) + wld);
                String rand = Character.toString(randChar);
                listA.add(rand);
            } else {
                char randChar = (char)(int) (Math.floor(Math.random() * wlZ) + wld);
                String rand = Character.toString(randChar);
                int in  = listA.size()-1;
                String lastIndex = listA.get(in);

                if(!rand.equals(lastIndex)) {
                    listA.add(rand);
                }
            }
        }
        //dodawanie elementów do tablicy B
        while (listB.size() < nB) {
            if(listB.size() == 0) {
                char randChar = (char)(int) (Math.floor(Math.random() * mlZ) + mld);
                String rand = Character.toString(randChar);
                listB.add(rand);
            } else {
                char randChar = (char)(int) (Math.floor(Math.random() * mlZ) + mld);
                String rand = Character.toString(randChar);
                int in = listB.size()-1;
                String lastIndex = listB.get(in);

                if(!rand.equals(lastIndex)) {
                    listB.add(rand);
                }
            }
        }
        //dodawanie elementów do tablicy C
        while (listC.size() < nC) {
            if(listC.size() == 0) {
                int randChar = (int) (Math.floor(Math.random() * cZ) + cd);
                String rand = Integer.toString(randChar);
                listC.add(rand);
            } else {
                int randChar = (int) (Math.floor(Math.random() * cZ) + cd);
                String rand = Integer.toString(randChar);
                int in = listC.size()-1;
                String lastIndex = listC.get(in);

                if(!rand.equals(lastIndex)) {
                    listC.add(rand);
                }
            }
        }

        // je¿eli chcemy wiêcej znaków w haœle ni¿ podaliœmy w minimalnych kryteriach
        if (nN >= 3) {
            int x = sub/3;

            if (nA != 0) {
                for (int i = 0; i < x; i++) {
                    addElementToList(listA, wlZ, wld);
                }
            }
            if (nB != 0) {
                for (int i = x; i < (x)*2; i++) {
                    addElementToList(listB, mlZ, mld);
                }
            }
            if (nC != 0) {
                for (int i = (x)*2; i < sub; i++) {
                    addElementToList(listC, cZ, cd);
                }
            }

            //je¿eli wszystkie 3 kryteria s¹ równe 0
            if ( nA == 0 && nB == 0 && nC == 0) {
                for (int i = 0; i < sub; i++) {
                    addElementToList(listA, wlZ, wld);
                }
            }
        } else {
            if (nA != 0) {
                for (int i = 0; i < nA; i++) {
                    addElementToList(listA, wlZ, wld);
                }
            }
            if (nB != 0) {
                for (int i = 0; i < nB; i++) {
                    addElementToList(listB, mlZ, mld);
                }
            }
            if (nC != 0) {
                for (int i = 0; i < nC; i++) {
                    addElementToList(listC, cZ, cd);
                }
            }

            //je¿eli wszystkie 3 kryteria s¹ równe 0
            if ( nA == 0 && nB == 0 && nC == 0 && sub !=0) {
                for (int i = 0; i < sub; i++) {
                    addElementToList(listA, wlZ, wld);
                }
            }
        }

        //dodawaj na zmianê elementy do tablicy
        int i = 0;
        while(i < nN) {
            if (!listA.isEmpty()) {
                listSub.add(listA.get(0));
                listA.remove(0);
            }
            if (!listB.isEmpty()) {
                listSub.add(listB.get(0));
                listB.remove(0);
            }
            if (!listC.isEmpty()) {
                listSub.add(listC.get(0));
                listC.remove(0);
            }
            i++;
        }

        listSub.forEach(System.out::print);
    }

    public static void addElementToList(ArrayList<String> list, int range, int bottomBound) {

        while (true) {
            if(list.size() == 0) {
                char randChar = (char)(int) (Math.floor(Math.random() * range) + bottomBound);
                String rand = Character.toString(randChar);
                list.add(rand);
            } else {
                char randChar = (char)(int) (Math.floor(Math.random() * range) + bottomBound);
                String rand = Character.toString(randChar);
                int in  = list.size()-1;
                String lastIndex = list.get(in);

                if(!rand.equals(lastIndex)) {
                    list.add(rand);
                    break;
                }
            }
        }
    }
}