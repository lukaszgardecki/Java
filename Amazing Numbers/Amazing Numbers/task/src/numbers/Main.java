package numbers;

import java.util.ArrayList;


//  input 1:    "L"             (wyœwietl wszystkie parametry dla liczby L)
//  input 2:    "L N"           (wyœwietl wszystkie parametry N kolejnych liczb zaczynaj¹c od L)
//  input 3:    "L N P1"        (wyœwietl N liczb, zawieraj¹cych parametr P1, wiêkszych lub równych ni¿ L)
//  input 4:    "L N P1 P2..."  (wyœwietla N liczb, zawieraj¹cych okreœlone parametry, wiêkszych lub równych ni¿ L)

public class Main {
    static Number num1;
    static ArrayList<String> mutExPropTab = new ArrayList<>();
    static ArrayList<String> notExistingParams = new ArrayList<>();

    public static void main(String[] args) {
        play();
    }

    public static void play() {
        displayMessage(7);                                                                                              //wyœwietl przywitanie
        displayMessage(1);                                                                                              //wyœwietl instrukcjê
        while (true) {
            displayMessage(2);                                                                                          //Wyœwietl "Enter a request:"
            try {
                num1 = new Number();                                                                                         //stwórz liczbê (nowy obiekt), na której bêd¹ wykonywane operacje
                if (num1.getNum() == 0) {                                                                                    //klawisz "0" - wyjœcie z programu
                    displayMessage(6);
                    break;
                } else if (num1.getNum(0) < 1) {                                                                          //sprawdŸ czy pierwsza liczba jest naturalna
                    displayMessage(4);
                } else if (num1.getAmountOfEl() == 1) {                                                                      //gdy wpisaliœmy poprawnie 1 parametr (jedn¹ liczbê)
                    displayParamOfNumber();
                } else if (num1.getNum(1) < 1) {                                                                           //sprawdŸ czy druga liczba jest naturalna
                    displayMessage(5);                                                                                  
                } else if (num1.getAmountOfEl() == 2 ) {                                                                      //gdy wpisaliœmy poprawnie dwa parametry
                    long down = num1.getNum();
                    long up =  down + num1.getNum(1);
                    displayNumbersFromTo(down, up);
                } else if (num1.getAmountOfEl() >= 3) {                                                                       //gdy wpisaliœmy minimum 4 parametry
                    checkProperties();
                }
            } catch (NumberFormatException e) {                                                                               //gdy wpisano zamiast parametru inne s³owa
                displayMessage(4);
            } catch (ArrayIndexOutOfBoundsException t) {
                displayMessage(1);                                                                                      //gdy wpisano zamiast parametru np, pust¹ spacjê
            }
            notExistingParams.clear();
            mutExPropTab.clear();
        }
    }

    
    public static void checkProperties() {                                                                                    //metoda sprawedzaj¹ca wprowadzone w³aœciwoœci liczb
        ArrayList<String> inP = num1.getInputProperties();
        boolean areAllParamsExist = true;
        boolean areExistEvenAndOdd = inP.contains("EVEN") && inP.contains("ODD");
        boolean areExistDuckAndSpy = inP.contains("DUCK") && inP.contains("SPY");
        boolean areExistSunnyAndSquare = inP.contains("SUNNY") && inP.contains("SQUARE");
        boolean areMutExProp = areExistEvenAndOdd || areExistDuckAndSpy || areExistSunnyAndSquare;
        long firstNum = num1.getNum();                                                                                        //pierwsza liczba
        long amoutOfNums = num1.getNum(1);                                                                                 //druga liczba
        long counter = 0;

        for (int i = 0; i < inP.size(); i++) {
            String inputProperty = inP.get(i);                                                                               //kolejna wprowadzona nazwa w³aœciwoœci
            boolean isParamExist =  num1.getPropertiesNames().contains(inputProperty);
            
            if (!isParamExist) {                                                                                             //je¿eli, któryœ z nazw w³aœciwoœci nie istnieje to dodaj go do listy b³êdnych nazw
                notExistingParams.add(inputProperty);
                areAllParamsExist = false;
            }
        }

        if (areExistEvenAndOdd) {                                                                                            //je¿eli wyst¹pi³ wypadek ¿e w³aœciwoœci liczb siê wykluczaj¹ to dodaj te w³aœciwoœci do listy
            mutExPropTab.add("EVEN");
            mutExPropTab.add("ODD");
        }
        if (areExistDuckAndSpy) {
            mutExPropTab.add("DUCK");
            mutExPropTab.add("SPY");
        }
        if (areExistSunnyAndSquare) {
            mutExPropTab.add("SUNNY");
            mutExPropTab.add("SQUARE");
        }

        if (areAllParamsExist && !areMutExProp) {
            System.out.println();
            while(counter < amoutOfNums) {
                Number num1 = new Number(firstNum);
                String output = createOutput(num1);
                boolean areAllParams = true;

                for (int i = 0; i < inP.size(); i++) {
                    String inputProperty = inP.get(i).toLowerCase();
                    boolean outputHasParam = output.contains(inputProperty);

                    if (!outputHasParam) {
                        areAllParams = false;
                        break;
                    }
                }
                if(areAllParams) {
                    System.out.print(output);
                    System.out.println();
                    counter++;
                }

                firstNum++;
            }
        } else if (!areAllParamsExist) {                                                                                      //je¿eli jakaœ nazwa w³aœciwoœci jest Ÿle wpisana
            displayMessage(8);
        } else {                                                                                                              //je¿eli wystêpuj¹ wykluczaj¹ce siê w³aœciwoœci
            displayMessage(11);
        }
    }
    
    public static String createOutput(Number num) {                                                                         //metoda wyœwietlaj¹ca wszystkie w³aœciwoœci danej liczby;
        String output = String.format("              %d is ",num.getNum());
        if(num.isEven()) output += "even ";
        if(num.isOdd()) output += "odd ";
        if(num.isBuzzNumber()) output += "buzz ";
        if(num.isDuckNumber()) output += "duck ";
        if(num.isPalindromic()) output += "palindromic ";
        if(num.isGapful()) output += "gapful ";
        if(num.isSpy()) output += "spy ";
        if(num.isSquare()) output += "square ";
        if(num.isSunny()) output += "sunny ";
        if(num.isJumping()) output += "jumping ";
        return output;
    }
    
    public static void displayParamOfNumber() {                                                                             //metoda wyœwietlaj¹ca wszystkie parametry dla 1 wartoœci (liczby)
        System.out.printf("\n"
                        +"Properties of %d"        +"\n"
                        +"        even: %b"        +"\n"
                        +"         odd: %b"        +"\n"
                        +"        buzz: %b"        +"\n"
                        +"        duck: %b"        +"\n"
                        +" palindromic: %b"        +"\n"
                        +"      gapful: %b"        +"\n"
                        +"         spy: %b"        +"\n"
                        +"      square: %b"        +"\n"
                        +"       sunny: %b"        +"\n"
                        +"     jumping: %b"        +"\n",
                num1.getNum(),
                num1.isEven(),
                num1.isOdd(),
                num1.isBuzzNumber(),
                num1.isDuckNumber(),
                num1.isPalindromic(),
                num1.isGapful(),
                num1.isSpy(),
                num1.isSquare(),
                num1.isSunny(),
                num1.isJumping());
    }
    
    public static void displayNumbersFromTo(long down, long up) {                                                            //metoda wyœwietlaj¹ca liczby je¿eli wprowadziliœmy 2 wartoœci
        System.out.println();
        for(long i = down; i < up; i++) {
            Number num1 = new Number(i);
            String output = createOutput(num1);
            System.out.print(output);
            System.out.println();
        }
    }
    
    public static void displayMessage(int msg) {                                                                                //metoda wyœwietlaj¹ca komunikaty
        switch (msg) {
            case 1:
                System.out.print("\n" + "\n"
                                + "Supported requests:"                                                               + "\n"
                                + "- enter a natural number to know its properties;"                                  + "\n"
                                + "- enter two natural numbers to obtain the properties of the list:"                 + "\n"
                                + "  * the first parameter represents a starting number;"                             + "\n"
                                + "  * the second parameter shows how many consecutive numbers are to be processed;"  + "\n"
                                + "- two natural numbers and properties to search for;"                               + "\n"
                                + "- separate the parameters with one space;"                                         + "\n"
                                + "- enter 0 to exit."                                                                + "\n");
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
                System.out.print("Welcome to Amazing Numbers!");
                break;
            case 8:
                String w = String.valueOf(notExistingParams);
                String x = String.valueOf(num1.getPropertiesNames());

                if (notExistingParams.size() == 1) {
                    System.out.printf(       "The property %s is wrong."       +  "\n"
                                           + "Available properties: %s",
                    w, x);
                } else {
                    System.out.printf(       "The properties %s are wrong."       +  "\n"
                                           + "Available properties: %s",
                    w, x);
                }
                break;
            case 11:
                String k = String.valueOf(mutExPropTab);
                System.out.printf("\n" + "The request contains mutually exclusive properties: %s"       + "\n"
                                       + "There are no numbers with these properties."                        + "\n",
                k);
                break;
        }
    }
}
