package Zad_59_Comparator2;

import java.io.File;

class PropertyTest {
    public static void main(String[] args) {
        File file = new File("src/Zad_59_Comparator2/properties.csv");
        PropertyDB db = new PropertyDB(file);
        db.sortAscByPriceForMetre();

        System.out.println("Dost�pne nieruchomo�ci:");
        System.out.println(db);
    }
}
