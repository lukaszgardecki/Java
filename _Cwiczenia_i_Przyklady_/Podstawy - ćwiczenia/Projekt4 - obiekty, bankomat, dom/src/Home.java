public class Home {
    public static void main(String[] args) {

        //Do domu dodajemy telewizory o nazwie nosy i sama:
        TV nosy = new TV(45, "nosy123");
        TV sama = new TV(32, "sama2345");

        //Wyświetl nazwy naszych telewizorów
        System.out.println(sama.getName() + " " + sama.getSize());
        System.out.println(nosy.getName() + " " + nosy.getSize());

        //pobierz info czy TV jest włączony (false)
        sama.getOnOff();

        //ustaw żeby tv był włączony
        sama.setOnOff(true);

        //pobierz info czy TV jest włączony (true)
        sama.getOnOff();

        //Do domu dodamy psa:
        Dog rex = new Dog();

        //pies wydaje dźwięki
        rex.speak();

        //został przypisany rozmiar do psa rex
        rex.setSize(15);
        //a następnie wydrukowany
        System.out.println(rex.getSize());


    }
}
