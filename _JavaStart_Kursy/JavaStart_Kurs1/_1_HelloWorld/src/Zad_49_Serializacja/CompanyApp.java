package Zad_49_Serializacja;

import java.io.*;

class CompanyApp {
    static Company cmp;

    public static void main(String[] args) {
        File file = new File("src/Zad_49_Serializacja/input.txt");

        createCompany();

        System.out.println("Teraz nastêpuje zapis do pliku:");
        saveTo(file);

        System.out.println("Teraz nastêpuje odczyt z pliku:");
        loadFrom(file);
    }

    private static void createCompany() {
        cmp = new Company();
        cmp.add(new Employee("Jan", "Kowalski", 2800));
        cmp.add(new Employee("Anna", "Kowalska", 5300));
        cmp.add(new Employee("Jerzy", "Zwie¿y", 2300));
    }

    private static void loadFrom(File file) {
        try (FileInputStream inputStream = new FileInputStream(file);
             ObjectInputStream ois = new ObjectInputStream(inputStream)) {

            cmp = (Company) ois.readObject();

        } catch (IOException | ClassNotFoundException e) {
            System.out.println("Nie uda³o siê oczytaæ pliku.");
            e.printStackTrace();
        }

    }

    private static void saveTo(File file) {
        try (FileOutputStream outputStream = new FileOutputStream(file);
             ObjectOutputStream os = new ObjectOutputStream(outputStream)) {

            os.writeObject(cmp);
            System.out.println("Zapisano obiekt do pliku.");

        } catch (IOException e) {
            System.err.println("B³¹d zapisu pliku " + file);
            e.printStackTrace();
        }
    }
}
