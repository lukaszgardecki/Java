package numbers;

public class Main {
    static Number num1;

    public static void main(String[] args) {
        play();
    }

    public static void play() {
        displayMessage(1);
        while (true) {
            displayMessage(2);
            try {
                num1 = new Number();

                if (num1.getNum() == 0) {
                    displayMessage(6);
                    break;
                } else if (!num1.isNatural()) {
                    displayMessage(4);
                } else if (num1.getAmountOfEl() == 2 && num1.getNum(1) < 1) {
                    displayMessage(5);
                } else if (num1.getAmountOfEl() == 2) {
                    long down = num1.getNum();
                    long up =  down + num1.getNum(1);
                    displayNumbersFromTo(down, up);
                } else if (num1.getAmountOfEl() == 3) {
                    long down = num1.getNum();
                    displayPropertyNumbers(down);
                } else {
                    displayMessage(7);
                }
            } catch (NumberFormatException e) {
                displayMessage(4);
            } catch (ArrayIndexOutOfBoundsException t) {
                displayMessage(1);
            }
        }
    }

    //metoda wyœwietlaj¹ca liczby je¿eli wprowadziliœmy zakres, iloœc liczb i rodzaj liczb
    public static void displayPropertyNumbers(long down) {
        boolean propertyIsExist = num1.getPropertiesNames().contains(num1.getProperty());
        long counter = 0;

        if (propertyIsExist) {
            System.out.println();
            while(counter < num1.getNum(1)) {
                Number num1 = new Number(down);
                String output = String.format("              %d is ",num1.getNum());
                if(num1.isEven()) output += "even ";
                if(num1.isOdd()) output += "odd ";
                if(num1.isBuzzNumber()) output += "buzz ";
                if(num1.isDuckNumber()) output += "duck ";
                if(num1.isPalindromic()) output += "palindromic ";
                if(num1.isGapful()) output += "gapful ";
                if(num1.isSpy()) output += "spy ";

                if(output.contains(Main.num1.getProperty().toLowerCase())) {
                    System.out.print(output);
                    System.out.println();
                    counter++;
                }
                down++;
            }
        } else {
            displayMessage(8);
        }
    }


    //metoda wyœwietlaj¹ca liczby je¿eli wprowadziliœmy zakres i iloœæ liczb
    public static void displayNumbersFromTo(long down, long up) {
        System.out.println();
        for(long i = down; i < up; i++) {
            Number num2 = new Number(i);
            String output = "";
            System.out.printf("              %d is ",num2.getNum());
            if(num2.isEven()) output += "even ";
            if(num2.isOdd()) output += "odd ";
            if(num2.isBuzzNumber()) output += "buzz ";
            if(num2.isDuckNumber()) output += "duck ";
            if(num2.isPalindromic()) output += "palindromic ";
            if(num2.isGapful()) output += "gapful ";
            if(num2.isSpy()) output += "spy ";

            System.out.print(output);
            System.out.println();
        }
    }

    //metoda wyœwietlaj¹ca komunikaty
    public static void displayMessage(int msg) {
        switch (msg) {
            case 1:
                System.out.print(
                        "Welcome to Amazing Numbers!"                                                                   +"\n"
                                                                                                                        +"\n"
                                +"Supported requests:"                                                                  +"\n"
                                +"- enter a natural number to know its properties;"                                     +"\n"
                                +"- enter two natural numbers to obtain the properties of the list:"                    +"\n"
                                +"  * the first parameter represents a starting number;"                                +"\n"
                                +"  * the second parameter shows how many consecutive numbers are to be printed;"       +"\n"
                                +"- two natural numbers and a property to search for;"                                  +"\n"
                                +"- separate the parameters with one space;"                                            +"\n"
                                +"- enter 0 to exit."                                                                   +"\n");
                break;
            case 2:
                System.out.print("\nEnter a request: ");
                break;
            case 4:
                System.out.println("\nThe first parameter should be a natural number or zero.");
                break;
            case 5:
                System.out.println("\nThe second parameter should be a natural number.");
                break;
            case 6:
                System.out.println("\nGoodbye!");
                break;
            case 7:
                System.out.printf("\n"
                                +"Properties of %d"        +"\n"
                                +"        even: %b"        +"\n"
                                +"         odd: %b"        +"\n"
                                +"        buzz: %b"        +"\n"
                                +"        duck: %b"        +"\n"
                                +" palindromic: %b"        +"\n"
                                +"      gapful: %b"        +"\n"
                                +"         spy: %b"        +"\n",
                        num1.getNum(),
                        num1.isEven(),
                        num1.isOdd(),
                        num1.isBuzzNumber(),
                        num1.isDuckNumber(),
                        num1.isPalindromic(),
                        num1.isGapful(),
                        num1.isSpy());
                break;
            case 8:
                String x = String.valueOf(num1.getPropertiesNames());
                System.out.printf(       "The property [%s] is wrong."       +"\n"
                                        +"Available properties: %s",
                        num1.getProperty().toUpperCase(), x);
        }
    }
}
