package Zad_62_Sety;

import java.io.*;
import java.util.Comparator;
import java.util.TreeSet;

class Names {
    private static TreeSet<String> names;
    private static File file;

    public static void main(String[] args) {
        names = new TreeSet<>(new Comparator<String>() {
            @Override
            public int compare(String s1, String s2) {
                return -s1.compareTo(s2);
            }
        });

        file = new File("src/Zad_62_Sety/namespl.txt");

        read();
        System.out.println("Liczba unikalnych imion w bazie: " + names.size());
        System.out.println("Pierwsze imiê w bazie: " + names.first());
        System.out.println("Ostatnie imiê w bazie: " + names.last());

    }

    private static void read() {
        try (FileReader fr = new FileReader(file);
             BufferedReader br = new BufferedReader(fr)
        ) {
            String name;
            while ((name = br.readLine()) != null) {
                names.add(name);
            }

        } catch (IOException e) {
            throw new RuntimeException(e);
        }
    }
}
