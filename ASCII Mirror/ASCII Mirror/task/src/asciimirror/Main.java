package asciimirror;

import javax.print.DocFlavor;
import java.io.File;
import java.io.FileNotFoundException;
import java.util.ArrayList;
import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        Scanner scanner1 = new Scanner(System.in);
        ArrayList<String> list = new ArrayList<>();
        ArrayList<String> mirrorList = new ArrayList<>();
        int maxLength = 0;

        System.out.println("Input the file path:");
        String path = scanner1.nextLine();
        File file = new File(path);

        try (Scanner scanner2 = new Scanner(file)) {
            while (scanner2.hasNextLine()) {
                String line = scanner2.nextLine();
                list.add(line);
                if(line.length() > maxLength) maxLength = line.length();
            }
        } catch (FileNotFoundException e) {
            System.out.println("File not found!");
        }

        for (int k = 0; k < list.size(); k++) {
            String line = "";
            int len = list.get(k).length();
            if (len != maxLength) {
                int sub = maxLength - len;
                list.set(k, list.get(k) + " ".repeat(sub));
            }
            line = list.get(k);

            StringBuilder sb = new StringBuilder(line);


            for (int i = 0; i < len; i++) {
                char ch = line.charAt(i);
                if (ch == '(') sb.replace(i, i+1, Character.toString(')'));
                if (ch == ')') sb.replace(i, i+1, Character.toString('('));
                if (ch == '{') sb.replace(i, i+1, Character.toString('}'));
                if (ch == '}') sb.replace(i, i+1, Character.toString('{'));
                if (ch == '[') sb.replace(i, i+1, Character.toString(']'));
                if (ch == ']') sb.replace(i, i+1, Character.toString('['));
                if (ch == '/') sb.replace(i, i+1, Character.toString('\\'));
                if (ch == '\\') sb.replace(i, i+1, Character.toString('/'));
                if (ch == '<') sb.replace(i, i+1, Character.toString('>'));
                if (ch == '>') sb.replace(i, i+1, Character.toString('<'));
            }
            sb.reverse();
            mirrorList.add(sb.toString());

        }

        for (int i = 0; i < list.size(); i++) {
            System.out.printf("%s | %s\n", list.get(i), mirrorList.get(i));
        }

//        String path = "F:\\1. S  T  U  D  I  A\\Æwiczenia z programowania\\Java\\ASCII Mirror\\ASCII Mirror\\task\\src\\asciimirror\\file3";
//        File file = new File(path);
//        long maxSub = -1;
//        int maxYear = 0;
//        ArrayList<Integer> yearList = new ArrayList<>();
//        ArrayList<Long> popList = new ArrayList<>();
//
//        try (Scanner scanner = new Scanner(file)) {
//            scanner.nextLine();
//            while (scanner.hasNextLine()) {
//                String[] tab = scanner.nextLine().split("\\s+");
//                int year = Integer.parseInt(tab[0]);
//                long pop = Long.parseLong(tab[1].replace(",", ""));
//                yearList.add(year);
//                popList.add(pop);
//            }
//
//            for (int i = 1; i < popList.size(); i++) {
//                long sub = Math.abs(popList.get(i) - popList.get(i-1));
//                if(sub > maxSub) {
//                    maxSub = sub;
//                    maxYear = yearList.get(i);
//                }
//            }
//            System.out.println(maxYear);
//        } catch (FileNotFoundException e) {
//            System.out.println("File no found: " + path);
//        }





//        String path = "F:\\1. S  T  U  D  I  A\\Æwiczenia z programowania\\Java\\ASCII Mirror\\ASCII Mirror\\task\\src\\asciimirror\\file2";
//        File file = new File(path);
//        int counter = 0;
//
//        try (Scanner scanner = new Scanner(file)) {
//            while(scanner.hasNextInt()) {
//                int num = scanner.nextInt();
//                if (num == 0) {
//                    break;
//                } else if (num % 2 == 0) {
//                    counter++;
//                }
//            }
//            System.out.println(counter);
//        } catch (FileNotFoundException e) {
//            System.out.println("File no found: " + path);
//        }




//        String path = "F:\\1. S  T  U  D  I  A\\Æwiczenia z programowania\\Java\\ASCII Mirror\\ASCII Mirror\\task\\src\\asciimirror\\file";
//        File file = new File(path);
//        int counter= 0;
//        try (Scanner scanner = new Scanner(file)) {
//            while (scanner.hasNextInt()) {
//                int num = scanner.nextInt();
//                if(num >= 9999) {
//                    counter++;
//                }
//            }
//            System.out.println(counter);
//        } catch (FileNotFoundException e) {
//            System.out.println("File no found: " + path);
//        }


//        String pathToFile = "F:\\1. S  T  U  D  I  A\\Æwiczenia z programowania\\Java\\ASCII Mirror\\ASCII Mirror\\task\\src\\asciimirror\\r";
//        try (Scanner scanner = new Scanner(new File(pathToFile))) {
//            System.out.println(scanner.nextInt());
//        } catch (FileNotFoundException e) {
//            System.out.println("No file found: " + pathToFile);
//        }


//        String path = "F:\\1. S  T  U  D  I  A\\Æwiczenia z programowania\\Java\\ASCII Mirror\\ASCII Mirror\\task\\src\\asciimirror\\te";
//        File file = new File(path);
//        int max = 0;
//        try (Scanner scanner = new Scanner(file)) {
//            while(scanner.hasNextInt()) {
//                int num = scanner.nextInt();
//                if(num >= max) {
//                    max = num;
//                }
//            }
//            System.out.println(max);
//        } catch (FileNotFoundException e) {
//            System.out.println("No file found: " + path);
//        }





//        Scanner scanner = new Scanner(System.in);
//        System.out.println("Input the file path:");
//        String text = scanner.nextLine();
//        System.out.println(text);
//
//        System.out.println("            ^__^");
//        System.out.println("    _______/(oo)");
//        System.out.println("/\\/(       /(__)");
//        System.out.println("   | w----||    ");
//        System.out.println("   ||     ||    ");
    }
}