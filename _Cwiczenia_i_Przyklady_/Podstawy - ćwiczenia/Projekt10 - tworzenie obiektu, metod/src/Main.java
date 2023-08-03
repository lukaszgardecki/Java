public class Main {
    public static void main(String[] args) {
        Uczen u1 = new Uczen();
        u1.setNazwisko("Nowak");

        System.out.println(u1.getNazwisko());

        System.out.println(u1.getOcena()); //jeżeli nic nie wstawimyu w nawias to wyświetli 0 ponieważ domyślną wartością inta jest 0
        u1.setOcena(4);
        System.out.println(u1.getOcena());
        u1.setOcena(9); //w klasie Uczen sprecyzowalismy, że oceny muszą być od 1 do 6 dlatego jeżeli wprowadzimy ocenę 9 to nie zostanie ona wyświetlona tylko zostanie wartośc  poprzednia czyli 4
        System.out.println(u1.getOcena());




    }

}
