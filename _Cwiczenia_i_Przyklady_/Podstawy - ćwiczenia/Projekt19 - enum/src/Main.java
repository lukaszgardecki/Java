
//Enum ("typ enumeryczny, typ wyliczeniowy"). Enum może istnieć wewnątrz klasy LUB jako osobny plik na poziomie równym z klasą. Jest to po prostu typ jakichś wartości, które my dupuszczamy, np. tylko okreslone modele samochodu, tylko jakiś okreslone kolory

public class Main {
    public static void main(String[] args) {
        Samochod bmw = new Samochod("BMW", Kolory.CZARNY);

        switch (bmw.kolor) {
            case BIALY:
                break;
            case CZARNY:
                break;
            case NIEBIESKI:
                break;
        }
    }


}
