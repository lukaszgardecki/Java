package numbers;


public class Main {

    public static void main(String[] args) {

        System.out.print(
                        "Welcome to Amazing Numbers!"                                                           +"\n"
                                                                                                                +"\n"
                        +"Supported requests:"                                                                  +"\n"
                        +"- enter a natural number to know its properties;"                                     +"\n"
                        +"- enter two natural numbers to obtain the properties of the list:"                    +"\n"
                        +"  * the first parameter represents a starting number;"                                +"\n"
                        +"  * the second parameter shows how many consecutive numbers are to be processed;"     +"\n"
                        +"- separate the parameters with one space;"                                            +"\n"
                        +"- enter 0 to exit."                                                                   +"\n");









        while (true) {
            System.out.print("\nEnter a request: ");
            Number num = new Number();

            //System.out.println(num.getNum(1));

            if (num.getNum() == 0) {
                System.out.println("\nGoodbye!");
                break;
            } else if (!num.isNatural()) {
                System.out.println("\nThe first parameter should be a natural number or zero.");
            } else if (num.amountOfEl() == 2 && num.getNum(1) < 1) {
                System.out.println("\nThe second parameter should be a natural number.");
            }




            else if (num.amountOfEl() == 2) {
                int down = (int) num.getNum();
                int up =  down + (int) num.getNum(1);

                for(int i = down; i < up; i++) {
                    Number num8 = new Number(i);
                    System.out.printf("%d is ",num8.getNum());
                    if(num8.isEven()) System.out.print("even ");
                    if(num8.isOdd()) System.out.print("odd ");
                    if(num8.isBuzzNumber()) System.out.print("buzz ");
                    if(num8.isDuckNumber()) System.out.print("duck ");
                    if(num8.isPalindromic()) System.out.print("palindromic ");
                    if(num8.isGapful()) System.out.print("gapful ");
                    System.out.println();


                }



            } else {
                System.out.printf(
                        "\nProperties of %d"        +"\n"
                       +"          even: %b"        +"\n"
                       +"           odd: %b"        +"\n"
                       +"          buzz: %b"        +"\n"
                       +"          duck: %b"        +"\n"
                       +"   palindromic: %b"        +"\n"
                       +"        gapful: %b"        +"\n",
                        num.getNum(),
                        num.isEven(),
                        num.isOdd(),
                        num.isBuzzNumber(),
                        num.isDuckNumber(),
                        num.isPalindromic(),
                        num.isGapful());
            }
        }

    }


}
