package numbers;

import java.lang.reflect.Array;
import java.util.ArrayList;

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
                //stw�rz liczb� (nowy obiekt), na kt�rej b�d� wykonywane operacje
                //  input 1:    "L"             (wy�wietl wszystkie parametry dla liczby L)
                //  input 2:    "L N"           (wy�wietl wszystkie parametry N kolejnych liczb zaczynaj�c od L)
                //  input 3:    "L N P1"        (wy�wietl N liczb, zawieraj�cych parametr P1, wi�kszych od L)
                //  input 4:    "L N P1 P2"     (
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
                }


//                else if (num1.getAmountOfEl() == 3) {
//                    //gdy wpisali�my trzy parametry
//                    displayPropertyNumbers();
//                }



                else if (num1.getAmountOfEl() >= 3) {
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









    //metoda dla wielu parametr�w
    public static void checkProperties() {

        //za�o�enie 1: wpisali�my przynajmniej dwa parametry!!!!!!!!!
        //za�o�enie 2: ta metoda ma zast�pi� m�tod� dla 3 i 4 wprowadzonych  element�w !!!!!!!!

        ArrayList<String> inP = num1.getInputProperties();

        boolean areAllParamsExist = true;
        boolean areExistEvenAndOdd = inP.contains("EVEN") && inP.contains("ODD");
        boolean areExistDuckAndSpy = inP.contains("DUCK") && inP.contains("SPY");
        boolean areExistSunnyAndSquare = inP.contains("SUNNY") && inP.contains("SQUARE");
        boolean areMutExProp = areExistEvenAndOdd || areExistDuckAndSpy || areExistSunnyAndSquare;

        for (int i = 0; i < inP.size(); i++) {
            String inputProperty = inP.get(i);                         //kolejna wprowadzona nazwa w�a�ciwo�ci
            boolean isParamExist =  num1.getPropertiesNames().contains(inputProperty);

            //je�eli, kt�ry� z nazw w�a�ciwo�ci nie istnieje to dodaj go do listy b��dnych nazw
            if (!isParamExist) {
                notExistingParams.add(inputProperty);
                areAllParamsExist = false;
            }
        }

        if (areExistEvenAndOdd) {
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






        long firstNum = num1.getNum(); //pierwsza liczba
        long amoutOfNums = num1.getNum(1); // druga liczba
        long counter = 0;

        if (areAllParamsExist && !areMutExProp) {
            System.out.println();
            while(counter < amoutOfNums) {
                Number num1 = new Number(firstNum);
                String output = createOutput(num1);
                boolean areAllParams = true;

                for (int i = 0; i < num1.getInputProperties().size(); i++) {
                    String inputProperty = Main.num1.getInputProperties().get(i).toLowerCase();
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
        } else if (areMutExProp) {
            //je�eli wyst�puj� wykluczaj�ce si� w�a�ciwo�ci
            displayMessage(11);
        } else {
            //je�eli jaka� nazwa w�a�ciwo�ci jest �le wpisana
            displayMessage(8);
        }



    }


    //metoda wy�wietlaj�ca liczby je�eli wprowadzili�my 4 warto�ci
//    public static void displayIfTwoParams() {
//        //sprawd�, czy podane parametry s� w�a�ciwie wpisane
//        String firstParam = num1.getInsertProperty(1);
//        String secondParam = num1.getInsertProperty(2);
//        boolean firstParamIsExist = num1.getPropertiesNames().contains(firstParam);
//        boolean secondParamIsExist = num1.getPropertiesNames().contains(secondParam);
//        boolean areMutExProp = firstParam.equalsIgnoreCase("EVEN") && secondParam.equalsIgnoreCase("ODD")
//                            || firstParam.equalsIgnoreCase("ODD") && secondParam.equalsIgnoreCase("EVEN")
//
//                            || firstParam.equalsIgnoreCase("DUCK") && secondParam.equalsIgnoreCase("SPY")
//                            || firstParam.equalsIgnoreCase("SPY") && secondParam.equalsIgnoreCase("DUCK")
//
//                            || firstParam.equalsIgnoreCase("SUNNY") && secondParam.equalsIgnoreCase("SQUARE")
//                            || firstParam.equalsIgnoreCase("SQUARE") && secondParam.equalsIgnoreCase("SUNNY");
//        long down = num1.getNum(); //pierwsza liczba
//        long amoutOfNums = num1.getNum(1); // druga liczba
//        long counter = 0;
//
//        if (firstParamIsExist && secondParamIsExist && !areMutExProp) {
//            System.out.println();
//            while(counter < amoutOfNums) {
//                Number num1 = new Number(down);
//                String output = createOutput(num1);
//
//                boolean outputHasFirstParam = output.contains(Main.num1.getInsertProperty(1).toLowerCase());
//                boolean outputHasSecondParam = output.contains(Main.num1.getInsertProperty(2).toLowerCase());
//
//                if(outputHasFirstParam && outputHasSecondParam) {
//                    System.out.print(output);
//                    System.out.println();
//                    counter++;
//                }
//                down++;
//            }
//        } else if (areMutExProp) {
//            //je�eli poprawnie wpisano par� wzajemnie wykluczaj�cych si� w�a�ciwo�ci
//            displayMessage(11);
//        } else if (!firstParamIsExist && !secondParamIsExist) {
//            //je�eli obie nazwy w�a�ciwo�ci s� b��dnie wpisane
//            displayMessage(10);
//        } else if (!firstParamIsExist) {
//            //je�eli tylko pierwsza nazwa jest b��dnie wpisana
//            displayMessage(8);
//        } else {
//            //je�eli tylko druga nazwa jest b��dnie wpisana
//            displayMessage(9);
//        }
//    }




    //metoda wy�wietlaj�ca wszystkie w�a�ciwo�ci danej liczby;
    public static String createOutput(Number num) {
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

    //metoda wy�wietlaj�ca wszystkie parametry dla 1 warto�ci (liczby)
    public static void displayParamOfNumber() {
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

    //metoda wy�wietlaj�ca liczby je�eli wprowadzili�my 2 warto�ci
    public static void displayNumbersFromTo(long down, long up) {
        System.out.println();
        for(long i = down; i < up; i++) {
            Number num2 = new Number(i);
            String output = createOutput(num2);
            System.out.print(output);
            System.out.println();
        }
    }

//    //metoda wy�wietlaj�ca liczby je�eli wprowadzili�my 3 warto�ci
//    public static void displayPropertyNumbers() {
//        long firstNum = num1.getNum();
//        String prop = num1.getInsertProperty(2);
//        boolean propertyIsExist = num1.getPropertiesNames().contains(prop);
//        long counter = 0;
//
//        if (propertyIsExist) {
//            System.out.println();
//            while(counter < num1.getNum(1)) {
//                num1 = new Number(firstNum);
//                String output = createOutput(num1);
//
//                if(output.contains(num1.getInsertProperty(2).toLowerCase())) {
//                    System.out.print(output);
//                    System.out.println();
//                    counter++;
//                }
//                firstNum++;
//            }
//        } else {
//            notExistingParams.add(prop);
//            displayMessage(8);
//        }
//    }

    //metoda wy�wietlaj�ca komunikaty
    public static void displayMessage(int msg) {
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
                    System.out.printf(       "The property %s are wrong."       +  "\n"
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
