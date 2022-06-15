package Dom;

public class Domek {

    public static void main(String[] args) {
        Telewizor tv1 = new Telewizor("Samsung", "XDS89YVS42", "czarny", 42);
        Telewizor tv2 = new Telewizor("Panasonic", "PN234v", "szary", 55);
        Telewizor tv3 = new Telewizor();

        tv1.jestWlaczony();
        tv3.setMarka("SONY");
        tv3.jestWylaczony();
    }


}
