import java.util.*;

public class Main {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        String vovels = "aeiouy";
        String consonants = "bcdfghjklmnpqrstvwxz";
        String input = scanner.nextLine();
        ArrayList<Integer> list = new ArrayList<>();
        int counterV = 0;
        int counterC = 0;
        String newWord = "";
        int sum = 0;

        //zamieñ s³owo na ci¹g znaków cvcvcccvvvcc
        for (int i = 0; i < input.length(); i++) {
            String sign = Character.toString(input.charAt(i));
            for (int j = 0; j < vovels.length(); j++) {
                if (sign.equals(Character.toString(vovels.charAt(j)))) {
                    newWord += "v";
                    break;
                }
            }
            for (int j = 0; j < consonants.length(); j++) {
                if (sign.equals(Character.toString(consonants.charAt(j)))) {
                    newWord += "c";
                    break;
                }
            }
        }

        for (int i = 0; i < newWord.length(); i++) {
            if (Character.toString(newWord.charAt(i)).equals("c")) {
                counterC++;
                if (counterV >= 3) list.add(counterV);
                counterV = 0;
            } else {
                counterV++;
                if (counterC >= 3) list.add(counterC);
                counterC = 0;
            }

            if (i == newWord.length()-1) {
                if (counterC > 0) {
                    list.add(counterC);
                } else{
                    list.add(counterV);
                }
            }
        }

        if (list.size() > 0) {
            for (Integer integer : list) {
                sum += ((integer - 1) / 2);
            }
        }
        System.out.println(sum);
    }
}