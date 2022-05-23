public class Animal {
    void makeVoice() {
        System.out.println("Grrrrr");
    }

    void eat() {
        System.out.println("Om om om ale dobre");
    }
    //--------------------------------KLASY WEWNĘTRZNE----------------
    //możemy utworzyć klasę wewnęrzną (wewnątrz już istniejącej klasy), nazwa tej klasy nie musi się zgadzać z nazwą pliku ale tylko dlatego, ta klasa znajduje się wewnątrz drugiej. Jakie są korzyści pisania klasy w klasie?? Główną zaletą jest to że klasa wewnętrzna ma cały czas dostęp do metod
    class Pet {
        String name;
        void getName() {
            System.out.println(name);
        }
    }

}
