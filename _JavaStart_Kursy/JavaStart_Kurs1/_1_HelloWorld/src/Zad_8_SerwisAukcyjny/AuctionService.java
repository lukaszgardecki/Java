package Zad_8_SerwisAukcyjny;

public class AuctionService {

    public static void main(String[] args) {

        Auction auction1 = new Auction();
        auction1.title = "Xbox One";
        auction1.description = "Konsola dla wymagaj¹cych graczy";
        auction1.price = 999.99;

        Seller seller1 = new Seller();
        seller1.firstName = "Jan";
        seller1.lastName = "Kowalski";

        Address address1 = new Address();
        address1.city = "Wroc³aw";
        address1.postalCode = "50-500";
        address1.street = "Koœciuszki";
        address1.homeNo = "24A";
        address1.flatNo = "21";

        seller1.address = address1;
        auction1.seller = seller1;


        Auction auction2 = new Auction();
        auction2.title = "Samsung S20";
        auction2.description = "Niesamowity telefon z trzema obiektywami";
        auction2.price = 3999;

        Seller seller2 = new Seller();
        seller2.firstName = "Justyna";
        seller2.lastName = "Adamczyk";

        auction2.seller = seller2;

    }
}
