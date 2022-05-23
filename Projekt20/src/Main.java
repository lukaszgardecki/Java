public class Main {
    public static void main(String[] args) {

        //metoda anonimowa. zawiera ciało. jest chwilowa czyli w dalszej części kodu jej nie ma
        Animal cat = new Animal(){
            @Override
            void makeVoice() {
                System.out.println("Meowww Meoow");
            }
        };

        cat.makeVoice();

        //ponieważ klasa anonimowa utworzona wyżej jest chwilowa, to nowo utworzony obiekt cat2 nie widzi już utworzonej w tej klasie metody makeVoice(), widzi wersję BAZOWĄ, tę pięrwszą podstawową makeVoice()
        Animal cat2 = new Animal();
        cat2.makeVoice();

        //cat2 je w sposób domyślny:
        cat2.eat();

        //cat też posiada tę metodę:
        cat.eat();

        //---------------------------------------------------------------------
        //------------KLASY WEWNĘTRZNE, INNER KLASY -----------------
        System.out.println("---------------------------");

        //Utworzenie obiektu należące do klasy wewnętrznej PET, sposób utworzenia jest inny!
        Animal.Pet pet = cat.new Pet();
        pet.name = "Bear";
        pet.getName();
    }
}
