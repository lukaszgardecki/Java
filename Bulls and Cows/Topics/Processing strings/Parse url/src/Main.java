import java.util.ArrayList;
import java.util.Scanner;

class Main {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        String[] tab1 = scanner.nextLine().split("\\?");
        String[] tab2 = tab1[1].split("&");
        ArrayList<String> list = new ArrayList<>(tab2.length+1);
        String temp = "";

        for (int i = 0; i < tab2.length; i++) {
            String[] tab3 = tab2[i].split("=");

            if (tab3.length == 1) {
                String[] tab4 = new String[2];
                tab4[0] = tab3[0];
                tab4[1] = "not found";
                list.add(String.format("%s : %s", tab4[0], tab4[1]));
            } else {
                list.add(String.format("%s : %s", tab3[0], tab3[1]));
            }
            if (tab3[0].equals("pass")) {
                temp = String.format("password : %s", tab3[1]);
            }
        }
        list.add(temp);
        list.forEach(System.out::println);
    }
}