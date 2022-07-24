package bullscows;
import java.util.Scanner;

public class Main {
    public static void main(String[] args) {



        Scanner scanner = new Scanner(System.in);
        int bullsCounter = 0;
        int cowsCounter = 0;
        String rand = Integer.toString((int) Math.floor(Math.random() * 9000) + 1000);

        System.out.println(rand);

        //typowanie liczby
        String num = Integer.toString(scanner.nextInt());

        for (int i = 0; i < num.length(); i++) {
            for (int j = 0; j < rand.length(); j++) {
                boolean bull = num.charAt(i) == rand.charAt(i);
                boolean cow = num.charAt(i) == rand.charAt(j);

                if (bull) {
                    bullsCounter++;
                    break;
                }
                if (cow) {
                    cowsCounter++;
                    break;
                }


            }
        }
        if (bullsCounter > 0 && cowsCounter > 0) {
            System.out.printf("Grade: %d bull(s) and %d cow(s). The secret code is %s.", bullsCounter, cowsCounter, rand);
        } else if (cowsCounter > 0) {
            System.out.printf("Grade: %d cow(s). The secret code is %s.", cowsCounter, rand);
        } else if (bullsCounter == 4) {
            System.out.printf("Grade: %d bull(s). The secret code is %s.", bullsCounter, rand);
        } else {
            System.out.printf("Grade: None. The secret code is %s.", rand);
        }

//        System.out.println("The secret code is prepared: ****.\n" +
//                "\n" +
//                "Turn 1. Answer:\n" +
//                "1234\n" +
//                "Grade: None.\n" +
//                "\n" +
//                "Turn 2. Answer:\n" +
//                "9876\n" +
//                "Grade: 4 bulls.\n" +
//                "Congrats! The secret code is 9876.");
    }


}
