package Zad_47_WyplatyPracownikow;

class CompanyApp {
    public static void main(String[] args) {
        Company company = new Company("Piekarnia Dobry Chlebek", 10);

        company.add(new FullTimeEmployee("Jan", "Kowalski", 5000.0));
        company.add(new FullTimeEmployee("Katarzyna", "Dobrabu³ka", 4803.4));
        company.add(new PartTimeEmployee("Zygmunt", "Bagieta", 20, 24));
        company.add(new PartTimeEmployee("Anna", "M¹czka", 15, 14));
        company.add(new FullTimeEmployee("Natural", "Zakwas", 2590.0));
        company.add(new PartTimeEmployee("Pomys³owy", "Dobromir", 290, 15.89));
        company.add(new FullTimeEmployee("Magdalena", "Twardaskórka", 7433.0));
        company.add(new PartTimeEmployee("Wojtek", "Damzafree", 10, 34.58));

        System.out.println(company);
    }
}
