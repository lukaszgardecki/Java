package Zad_82_Optional2;

import java.util.Scanner;

class ContactApp {
    public static void main(String[] args) {
        ContactReader.readFile("contacts.csv")
                .ifPresentOrElse(ContactApp::findByEmail, ContactApp::fileNotFoundMessage);
    }

    private static void fileNotFoundMessage() {
        System.out.println("Brak pliku z danymi.");
    }

    private static void findByEmail(ContactManager contactManager) {
        Scanner scanner = new Scanner(System.in);
        System.out.println("Podaj adres email do wyszukania kontaktu:");
        String email = scanner.nextLine();

        contactManager.findByEmail(email)
                .ifPresentOrElse(ContactApp::showShortInfo, ContactApp::contactNotFoundMessage);
    }

    private static void contactNotFoundMessage() {
        System.out.println("Brak kontaktu o wskazanym adresie email.");
    }

    private static void showShortInfo(Contact contact) {
        System.out.println("Kontakt o wskazanym adresie email:");
        System.out.println(contact.getShortInfo());
    }


}
