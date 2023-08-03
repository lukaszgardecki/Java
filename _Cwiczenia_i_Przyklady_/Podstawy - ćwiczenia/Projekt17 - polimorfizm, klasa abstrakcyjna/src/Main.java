public class Main {
    public static void main(String[] args) {
        Cat kot = new Cat();
        kot.dajGlos();
        kot.idz();

        System.out.println();

        //tylko spróbuj wykonać kod między nawiasami klamrowymi ale niekoniecznie musi ci się to udać
        try {
            Animal pies = new Dog("");
            pies.dajGlos();
            ((Dog) pies).idz();
            int a = 5 / 0;
        } catch (ClassCastException e) {
            System.out.println(e.getMessage());
        } catch (ArithmeticException e) {
            System.out.println("Blad arytmetyczny");
        } catch (Exception e) {
            System.out.println("inny blad");
            System.out.println(e.getMessage());
        } finally {
            System.out.println("\nWykonuje sie i tak");
        }




    }
}
