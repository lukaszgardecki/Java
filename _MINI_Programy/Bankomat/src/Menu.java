import java.io.IOException;
import java.text.DecimalFormat;
import java.util.HashMap;
import java.util.Map.Entry;
import java.util.Scanner;

public class Menu extends Account {
    Scanner menuInput = new Scanner(System.in);
    DecimalFormat moneyFormat = new DecimalFormat("'$'###,##0.00");
    HashMap<Integer, Integer> data = new HashMap<Integer, Integer>();

    public void getLogin() throws IOException {
        int x = 1;

        do {
            try {
                data.put(123456, 123);
                data.put(212212, 212);
                System.out.println("Welcome the ATM project");
                System.out.println("Enter your customer number");
                setCustomerNumber(menuInput.nextInt());
                System.out.println("Enter your pin number");
                setPinNumber(menuInput.nextInt());

            } catch (Exception e) {
                System.out.println("Invalid character, Enter only Number" + "\n");
                x=2;
            }

            for (Entry<Integer, Integer> entry : data.entrySet()) {
                if (entry.getKey() == getCustomerNumber() && entry.getValue() == getPinNumber()) {
                    getAccountType();
                }
            }
            System.out.println("Wrong customer number or id" + "\n");

        } while (x==1);
    }
    int selection;

    //display Acocunt type menu
    public void getAccountType() {
        System.out.println("Select the Account you want to acces");
        System.out.println("Type 1: Checking Account");
        System.out.println("Type 2: Saving Account");
        System.out.println("Type 3: Exit");
        System.out.println("Choice: ");

        selection = menuInput.nextInt();

        switch (selection) {
            case 1:
                getCheckingBalance();
                break;
            case 2:
                getSavingBalance();
                break;
            case 3:
                System.out.println("Thank you for using this ATM, Bye");
                break;
            default:
                System.out.println("Invalid choice"+"\n");
                getAccountType();
        }
    }


    //display checking account menu with selection
    public void getChcking() {
        System.out.println("Checking Acocunt");
        System.out.println("Type 1: View Balance");
        System.out.println("Type 2: Withdraw founds");
        System.out.println("Type 3: Deposit funds");
        System.out.println("Type 4: Exit");
        System.out.println("Choice: "+"\n");

        selection = menuInput.nextInt();

        switch (selection) {
            case 1:
                System.out.println("Checking Account balance" + moneyFormat.format(getCheckingBalance()));
                getAccountType();
                break;
            case 2:
                getCheckingWithdrawalInput();
                getAccountType();
                break;
            case 3:
                getCheckingDepositInput();
                getAccountType();
                break;
            default:
                System.out.println("\n"+"Invalid choice"+"\n");
                getChcking();
        }
    }

    //Display saving account menu with selection
    public void getSaving() {
        System.out.println("Saving Acocunt");
        System.out.println("Type 1: View Balance");
        System.out.println("Type 2: Withdraw founds");
        System.out.println("Type 3: Deposit funds");
        System.out.println("Type 4: Exit");
        System.out.println("Choice: "+"\n");

        selection = menuInput.nextInt();

        switch (selection) {
            case 1:
                System.out.println("Saving Account balance" + moneyFormat.format(getSavingBalance()));
                getAccountType();
                break;
            case 2:
                getSavingWithdrawInput();
                getAccountType();
                break;
            case 3:
                getSavingDepositInput();
                getAccountType();
                break;
            default:
                System.out.println("\n"+"Invalid choice"+"\n");
                getSaving();
        }
    }
}
