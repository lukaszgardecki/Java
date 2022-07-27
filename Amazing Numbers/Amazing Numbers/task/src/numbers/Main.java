package numbers;

import java.util.ArrayList;


//  input 1:    "L"             (wy�wietl wszystkie parametry dla liczby L)
//  input 2:    "L N"           (wy�wietl wszystkie parametry N kolejnych liczb zaczynaj�c od L)
//  input 3:    "L N P1"        (wy�wietl N liczb, zawieraj�cych parametr P1, wi�kszych lub r�wnych ni� L)
//  input 4:    "L N P1 P2..."  (wy�wietla N liczb, zawieraj�cych okre�lone parametry, wi�kszych lub r�wnych ni� L)

public class Main {
    static Number num1;
    static ArrayList<String> mutExPropTab = new ArrayList<>();
    static ArrayList<String> notExistingParams = new ArrayList<>();

    public static void main(String[] args) {
        play();
    }

    public static void play() {
        //wy�wietl przywitanie
        displayMessage(7);
        //wy�wietl instrukcj�
        displayMessage(1);
        while (true) {
            //Wy�wietl "Enter a request:"
            displayMessage(2);
            try {
                //stw�z input
                num1 = new Number();

                if (num1.getNum() == 0) {
                    //klawisz "0" - wyj�cie z programu
                    displayMessage(6);
                    break;
                } else if (num1.getNum(0) < 1) {
                    //sprawd� czy pierwsza liczba jest naturalna
                    displayMessage(4);
                } else if (num1.getAmountOfEl() == 1) {
                    //gdy wpisali�my poprawnie 1 parametr (jedn� liczb�)
                    displayParamOfNumber();
                } else if (num1.getNum(1) < 1) {
                    //sprawd� czy druga liczba jest naturalna
                    displayMessage(5);
                } else if (num1.getAmountOfEl() == 2 ) {
                    //gdy wpisali�my poprawnie dwa parametry
                    long down = num1.getNum();
                    long up =  down + num1.getNum(1);
                    displayNumbersFromTo(down, up);
                } else if (num1.getAmountOfEl() >= 3) {
                    //gdy wpisali�my minimum 4 parametry
                    checkProperties();
                }
            } catch (NumberFormatException e) {
                //gdy wpisano zamiast parametru inne s�owa
                displayMessage(4);
            } catch (ArrayIndexOutOfBoundsException t) {
                //gdy wpisano zamiast parametru np, pust� spacj�
                displayMessage(1);
            }

            notExistingParams.clear();
            mutExPropTab.clear();
        }
    }

    public static void checkProperties() {                                                                                    //metoda sprawedzaj�ca wprowadzone w�a�ciwo�ci liczb
        ArrayList<String> inP = num1.getInputProperties();
        boolean areAllParamsExist = true;
        boolean areMutExProp = checkMutExProp(inP);
        long firstNum = num1.getNum();                                                                                        //pierwsza liczba
        long amoutOfNums = num1.getNum(1);                                                                                 //druga liczba
        long counter = 0;

        for (int i = 0; i < inP.size(); i++) {
            //kolejna wprowadzona nazwa w�a�ciwo�ci
            String inputProperty = inP.get(i);
            boolean isParamExist = false;
            boolean isStartWithMinus = inputProperty.startsWith("-");

            //je�eli w�a�ciwo�� zaczyna si� minusem to chwilowo go usu�
            if (isStartWithMinus) {
                StringBuilder tempSB = new StringBuilder(inputProperty);
                inputProperty = tempSB.deleteCharAt(0).toString();
            }

            //sprawd� czy kolejna wpisana w�a�ciwo�� na pewno wyst�puje w tablicy nazw w�a�ciwo�ci
            for (int k = 0; k < num1.getPropertiesNames().size();k++) {
                isParamExist = num1.getListProperty(k).equalsIgnoreCase(inputProperty);
                if (isParamExist) break;
            }

            if (!isParamExist) {
                //je�eli, kt�ry� z nazw w�a�ciwo�ci nie istnieje to dodaj go do listy b��dnych nazw
                if (isStartWithMinus) {
                    notExistingParams.add(inP.get(i));
                } else {
                    notExistingParams.add(inputProperty);
                }
                areAllParamsExist = false;
            }
        }

        if (areAllParamsExist && !areMutExProp) {
            System.out.println();
            while(counter < amoutOfNums) {
                Number num1 = new Number(firstNum);
                String output = String.valueOf(createOutput(num1));
                boolean areAllParams = true;

                for (int i = 0; i < inP.size(); i++) {
                    String inputProperty = inP.get(i).toLowerCase();
                    boolean isStartWithMinus = inputProperty.startsWith("-");

                    //je�eli w�a�ciwo�� zaczyna si� minusem to chwilowo go usu�
                    if (isStartWithMinus) {
                        StringBuilder tempSB = new StringBuilder(inputProperty);
                        inputProperty = tempSB.deleteCharAt(0).toString();

                        //je�eli output ma t� warto�� to szukaj nastepnej liczby
                        boolean outputHasParam = output.contains(inputProperty);
                        if (outputHasParam) {
                            areAllParams = false;
                            break;
                        }
                    } else {
                        boolean outputHasParam = output.contains(inputProperty);

                        if (!outputHasParam) {
                            areAllParams = false;
                            break;
                        }
                    }
                }
                if(areAllParams) {
                    System.out.print(output);
                    System.out.println();
                    counter++;
                }
                firstNum++;
            }
        } else if (!areAllParamsExist) {                                                                                      //je�eli jaka� nazwa w�a�ciwo�ci jest �le wpisana
            displayMessage(8);
        } else {                                                                                                              //je�eli wyst�puj� wykluczaj�ce si� w�a�ciwo�ci
            displayMessage(11);
        }
    }

    public static boolean checkMutExProp(ArrayList<String> inP) {
        boolean areExistEvenAndOdd = inP.contains("EVEN") && inP.contains("ODD");
        boolean areExistEvenAndOddMinus = inP.contains("-EVEN") && inP.contains("-ODD");
        boolean areExistDuckAndSpy = inP.contains("DUCK") && inP.contains("SPY");
        boolean areExistSunnyAndSquare = inP.contains("SUNNY") && inP.contains("SQUARE");
        boolean areExistSadAndHappy = inP.contains("SAD") && inP.contains("HAPPY");

        boolean areExistEvenPlusMinus = inP.contains("EVEN") && inP.contains("-EVEN");
        boolean areExistOddPlusMinus = inP.contains("ODD") && inP.contains("-ODD");
        boolean areExistDuckPlusMinus = inP.contains("DUCK") && inP.contains("-DUCK");
        boolean areExistSpyPlusMinus = inP.contains("SPY") && inP.contains("-SPY");
        boolean areExistSunnyPlusMinus = inP.contains("SUNNY") && inP.contains("-SUNNY");
        boolean areExistSquarePlusMinus = inP.contains("SQUARE") && inP.contains("-SQUARE");
        boolean areExistHappyPlusMinus = inP.contains("HAPPY") && inP.contains("-HAPPY");
        boolean areExistSadPlusMinus = inP.contains("SAD") && inP.contains("-SAD");
        boolean areExistGapfulPlusMinus = inP.contains("GAPFUL") && inP.contains("-GAPFUL");
        boolean areExistPalindromicPlusMinus = inP.contains("PALINDROMIC") && inP.contains("-PALINDROMIC");
        boolean areExistJumpingPlusMinus = inP.contains("JUMPING") && inP.contains("-JUMPING");
        boolean areExistBuzzPlusMinus = inP.contains("BUZZ") && inP.contains("-BUZZ");

        boolean areMutExProp = areExistEvenAndOdd
                || areExistDuckAndSpy
                || areExistSunnyAndSquare
                || areExistSadAndHappy
                || areExistEvenAndOddMinus
                || areExistEvenPlusMinus
                || areExistOddPlusMinus
                || areExistDuckPlusMinus
                || areExistSpyPlusMinus
                || areExistSunnyPlusMinus
                || areExistSquarePlusMinus
                || areExistHappyPlusMinus
                || areExistSadPlusMinus
                || areExistGapfulPlusMinus
                || areExistPalindromicPlusMinus
                || areExistJumpingPlusMinus
                || areExistBuzzPlusMinus;

        if (areExistEvenAndOdd) {                                                                                            //je�eli wyst�pi� wypadek �e w�a�ciwo�ci liczb si� wykluczaj� to dodaj te w�a�ciwo�ci do listy
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
        if (areExistSadAndHappy) {
            mutExPropTab.add("SAD");
            mutExPropTab.add("HAPPY");
        }
        if (areExistEvenAndOddMinus) {
            mutExPropTab.add("-EVEN");
            mutExPropTab.add("-ODD");
        }
        if (areExistBuzzPlusMinus) {
            mutExPropTab.add("BUZZ");
            mutExPropTab.add("-BUZZ");
        }
        if (areExistDuckPlusMinus) {
            mutExPropTab.add("DUCK");
            mutExPropTab.add("-DUCK");
        }
        if (areExistPalindromicPlusMinus) {
            mutExPropTab.add("PALINDROMIC");
            mutExPropTab.add("-PALINDROMIC");
        }
        if (areExistGapfulPlusMinus) {
            mutExPropTab.add("GAPFUL");
            mutExPropTab.add("-GAPFUL");
        }
        if (areExistSpyPlusMinus) {
            mutExPropTab.add("SPY");
            mutExPropTab.add("-SPY");
        }
        if (areExistEvenPlusMinus) {
            mutExPropTab.add("EVEN");
            mutExPropTab.add("-EVEN");
        }
        if (areExistOddPlusMinus) {
            mutExPropTab.add("ODD");
            mutExPropTab.add("-ODD");
        }
        if (areExistSquarePlusMinus) {
            mutExPropTab.add("SQUARE");
            mutExPropTab.add("-SQUARE");
        }
        if (areExistSunnyPlusMinus) {
            mutExPropTab.add("SUNNY");
            mutExPropTab.add("-SUNNY");
        }
        if (areExistJumpingPlusMinus) {
            mutExPropTab.add("JUMPING");
            mutExPropTab.add("-JUMPING");
        }
        if (areExistSadPlusMinus) {
            mutExPropTab.add("SAD");
            mutExPropTab.add("-SAD");
        }
        if (areExistHappyPlusMinus) {
            mutExPropTab.add("HAPPY");
            mutExPropTab.add("-HAPPY");
        }

        return areMutExProp;
    }

    public static StringBuilder createOutput(Number num) {                                                                         //metoda wy�wietlaj�ca wszystkie w�a�ciwo�ci danej liczby;
        String startText = String.format("              %d is ",num.getNum());
        StringBuilder output = new StringBuilder(startText);
        if(num.isEven()) output.append("even, ");
        if(num.isOdd()) output.append("odd, ");
        if(num.isBuzzNumber()) output.append("buzz, ");
        if(num.isDuckNumber()) output.append("duck, ");
        if(num.isPalindromic()) output.append("palindromic, ");
        if(num.isGapful()) output.append("gapful, ");
        if(num.isSpy()) output.append("spy, ");
        if(num.isSquare()) output.append("square, ");
        if(num.isSunny()) output.append("sunny, ");
        if(num.isJumping()) output.append("jumping, ");
        if(num.isSad()) output.append("sad, ");
        if(num.isHappy()) output.append("happy, ");

        output.deleteCharAt(output.length()-2);
        return output;
    }
    
    public static void displayParamOfNumber() {                                                                             //metoda wy�wietlaj�ca wszystkie parametry dla 1 warto�ci (liczby)
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
                        +"     jumping: %b"        +"\n"
                        +"         sad: %b"        +"\n"
                        +"       happy: %b"        +"\n",
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
                num1.isJumping(),
                num1.isSad(),
                num1.isHappy());
    }
    
    public static void displayNumbersFromTo(long down, long up) {                                                            //metoda wy�wietlaj�ca liczby je�eli wprowadzili�my 2 warto�ci
        System.out.println();
        for(long i = down; i < up; i++) {
            Number num1 = new Number(i);
            String output = String.valueOf(createOutput(num1));
            System.out.print(output);
            System.out.println();
        }
    }
    
    public static void displayMessage(int msg) {                                                                                //metoda wy�wietlaj�ca komunikaty
        switch (msg) {
            case 1:
                System.out.print("\n" + "\n"
                                + "Supported requests:"                                                               + "\n"
                                + "- enter a natural number to know its properties;"                                  + "\n"
                                + "- enter two natural numbers to obtain the properties of the list:"                 + "\n"
                                + "  * the first parameter represents a starting number;"                             + "\n"
                                + "  * the second parameter shows how many consecutive numbers are to be processed;"  + "\n"
                                + "- two natural numbers and properties to search for;"                               + "\n"
                                + "- a property preceded by minus must not be present in numbers;"                    + "\n"
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
