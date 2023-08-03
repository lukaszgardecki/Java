public class Main {

        // -------- Metoda Equals i ==
    //Equals porównuje referencje

    public static void main(String[] args) {
        Animal a1 = new Animal();
        Animal a2 = new Animal();

        a1.name = "Tom";
        a2.name = "Tom";


        System.out.println(5 == 5);
        System.out.println("A" == "A");
        System.out.println(a1 == a2);

        System.out.println(a1.equals(a2));
    }
}
