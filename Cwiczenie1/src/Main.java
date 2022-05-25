public class Main {

    //Sumowanie liczb od 1 do 10

    public static void main(String[] args) {
        //1 + 2 +3 + .. + n

        int n = 10;
        int suma = 0;



        //Sposób 1:
        for (int i = 1; i <= n; i++) {
            suma = suma + i;
        }
        System.out.println("Sposób 1. Suma liczb od " + n + " to: " + suma);


        //Sposób 2:
//                1 10
//                2 9
//                3 8
//                4 7
//                5 6
        if ( n%2==0 ) {
            suma = (n + 1) * n/2;
        } else {
            suma = (n + 1) / 2 * n;
        }

        System.out.println("Sposób 2. Suma liczb od " + n + " to: " + suma);
    }
}
