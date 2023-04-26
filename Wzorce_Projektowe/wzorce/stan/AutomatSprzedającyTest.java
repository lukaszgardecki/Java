package wzorce.stan;

public class AutomatSprzedającyTest {
    public static void main(String[] args) {
        AutomatSprzedający automatSprzedający = new AutomatSprzedający(5);

        System.out.println(automatSprzedający);

        automatSprzedający.włóżMonetę();
        automatSprzedający.przekręćGałkę();

        System.out.println(automatSprzedający);

        automatSprzedający.włóżMonetę();
        automatSprzedający.przekręćGałkę();
        automatSprzedający.włóżMonetę();
        automatSprzedający.przekręćGałkę();

        System.out.println(automatSprzedający);
    }
}
