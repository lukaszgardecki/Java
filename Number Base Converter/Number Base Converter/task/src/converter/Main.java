package converter;

import java.math.BigDecimal;
import java.math.BigInteger;
import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        turnConverterOn();
    }

    public static void turnConverterOn() {
        while (true) {
            Scanner scanner = new Scanner(System.in);
            String[] t;

            try {
                do {
                    System.out.print("\nEnter two numbers in format: {source base} {target base} (To quit type /exit) ");
                    t = scanner.nextLine().split("\\s+");
                    if (t[0].equals("/exit")) return;
                    if (t.length != 2) System.err.println("Enter two numbers! Try again!");
                } while (t.length != 2);

                int base1 = Integer.parseInt(t[0]);
                int base2 = Integer.parseInt(t[1]);

                convert(base1, base2);
            } catch (NumberFormatException | ArrayIndexOutOfBoundsException e) {
                System.err.println("Enter two numbers! Try again!");
            }

            //String fromTo = scanner.nextLine();

           // Conversion conversion;

//            switch (fromTo) {
//                case "/from":
//                    conversion = new Conversion(new FromDecimal());
//                    conversion.execute();
//                    break;
//                case "/to":
//                    conversion = new Conversion(new ToDecimal());
//                    conversion.execute();
//                    break;
//                case "/exit":
//                    return;
//                default:
//                    System.err.println("Unknown operation. Try again!");
//            }
        }
    }

    public static void convert(int baseFrom, int baseTo) {
        Scanner scanner = new Scanner(System.in);

        while (true) {
            System.out.printf("Enter number in base %d to convert to base %d (To go back type /back) ", baseFrom, baseTo);
            String num = scanner.nextLine();
            if (num.equals("/back")) return;


            BigInteger n = new BigInteger(num, baseFrom);
            String n2 = n.toString();
            String m = new BigInteger(n2).toString(baseTo);

            //String n = Integer.toString(decimalNum, targetBase);
            System.out.printf("Conversion result: %s\n\n", m);
        }
    }
}


//
//    class Conversion {
//        private final FindingConversion conversion;
//
//        public Conversion (FindingConversion conversion) {
//            this.conversion = conversion;
//        }
//
//        public void execute() {
//            conversion.convert();
//        }
//    }
//
//
//    interface FindingConversion {
//        void convert();
//    }
//
//    class FromDecimal implements FindingConversion {
//
//        @Override
//        public void convert() {
//            Scanner scanner = new Scanner(System.in);
//
//            System.out.println("Enter number in base 10 to convert to base 2 (To go back type /back) ");
//            String[] tab = scanner.nextLine().split("\\s+");
//
//
//            //System.out.print("Enter number in decimal system: ");
//            int decimalNum = Integer.parseInt(scanner.nextLine());
//
//            //System.out.print("Enter target base: ");
//            int targetBase = scanner.nextInt();
//
//            String n = Integer.toString(decimalNum, targetBase);
//            System.out.printf("Conversion result: %s\n", n);
//
//        }
//    }
//
//    class ToDecimal implements FindingConversion {
//
//        @Override
//        public void convert() {
//            Scanner scanner = new Scanner(System.in);
//
//            System.out.print("Enter source number: ");
//            String num = scanner.nextLine();
//
//            System.out.print("Enter source base: ");
//            int targetBase = scanner.nextInt();
//
//            int n = Integer.parseInt(num, targetBase);
//            System.out.printf("Conversion to decimal result: %d\n", n);
//        }
//
//    }
//
//




