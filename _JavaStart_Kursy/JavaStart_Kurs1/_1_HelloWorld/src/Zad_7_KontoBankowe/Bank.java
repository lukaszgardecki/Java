package Zad_7_KontoBankowe;

class Bank {
    public static void main(String[] args) {

        Person person1 = new Person();
        person1.firstName = "Jan";
        person1.lastName = "Kowalski";
        person1.pesel = "90897812362";

        Address address1 = new Address();
        address1.city = "Katowice";
        address1.houseNum = "3";
        address1.flatNum = "12";
        address1.street = "Bia³owiejskiego";
        address1.zipCode = "41-345";

        person1.address = address1;
        person1.registeredAddress = address1;

        BankAccount account1 = new BankAccount();
        account1.owner = person1;
        account1.balance = 10_000;

        Credit credit1 = new Credit();
        credit1.borrower = person1;
        credit1.cashBorrowed = 5000;
        credit1.cashReturned = 0;
        credit1.interestRate = 0.10;
        credit1.termMonths = 12;

        Person person2 = new Person();
        person2.firstName = "Marta";
        person2.lastName = "Kowalska";
        person2.pesel = "90897812324";

        Address address2 = new Address();
        address2.city = "Warszawa";
        address2.houseNum = "23";
        address2.flatNum = "124";
        address2.street = "Konarskiego";
        address2.zipCode = "41-255";

        person2.address = address1;
        person2.registeredAddress = address2;

        BankAccount account2 = new BankAccount();
        account2.owner = person2;
        account2.balance = 455_000;

        Credit credit2 = new Credit();
        credit2.borrower = person2;
        credit2.cashBorrowed = 7000;
        credit2.cashReturned = 0;
        credit2.interestRate = 0.10;
        credit2.termMonths = 12;

        System.out.println("Osoba 1:");
        System.out.println(person1.firstName + " " + person1.lastName);
        System.out.println("mieszka w miejscowoœci: " + person1.address.city);
        System.out.println("posiada konto bankowe z kwot¹: " + account1.balance);
        System.out.println("oraz kredyt na kwotê " + credit1.cashBorrowed);
        System.out.println("Osoba 2:");
        System.out.println(person2.firstName + " " + person2.lastName);
        System.out.println("mieszka w miejscowoœci: " + person2.address.city);
        System.out.println("posiada konto bankowe z kwot¹: " + account2.balance);
        System.out.println("oraz kredyt na kwotê " + credit2.cashBorrowed);
    }
}
