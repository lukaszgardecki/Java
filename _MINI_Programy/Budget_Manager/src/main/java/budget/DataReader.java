package budget;

import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileWriter;
import java.io.IOException;
import java.util.*;

public class DataReader {
    private final Scanner scanner;
    private final Printer printer;
    private final String filePath = "purchases.txt";

    public DataReader(Printer printer) {
        this.scanner = new Scanner(System.in);
        this.printer = printer;
    }

    public String getString() {
        return scanner.nextLine();
    }

    public int getInt() {
        boolean intOK = false;
        int num = -1;
        do {
            try {
                num = scanner.nextInt();
                if (num < 0) throw new InputMismatchException();
                intOK = true;
            } catch (InputMismatchException e) {
                printer.println(Message.INCORRECT_INT);
            }
        } while (!intOK);
        return num;
    }


    public Option getOptionFromInt() {
        Option option;
        do {
            int enteredValue = getInt();
            option = Arrays.stream(Option.values())
                    .filter(o -> o.getValue() == enteredValue)
                    .findFirst()
                    .orElseThrow(() -> new IllegalArgumentException(Message.BAD_OPT_NUM));
        } while (option == null);
        return option;
    }

    public void saveFile() {
        File file = new File(filePath);

        try (FileWriter writer = new FileWriter(file)) {

            writer.write(String.format("Balance: $%.2f\n\n", balance));

            for(Map.Entry<Integer, TypesOfProducts> el : map.entrySet()) {
                int num = el.getKey();

                String nameOfCategory = el.getValue().getName();
                double sumOfCategory = el.getValue().getSum();
                ArrayList<String> list = el.getValue().getBoughtProducts();

                StringBuilder sb = new StringBuilder();

                if (list.size() == 0) {
                    String t = "\tThe purchase list is empty!\n";
                    sb = new StringBuilder(t);
                } else {
                    for (String pos : list) {

                        int indexLast$ = pos.lastIndexOf("$");

                        String name = pos.substring(0,indexLast$);
                        String price = pos.substring(indexLast$ + 1);
                        String designOfPos = String.format("\t- %40s $%s\n", name, price);
                        sb.append(designOfPos);
                    }
                }

                String listOfPurchases = sb.toString();

                String text = String.format(
                        "%d %s:"     +"\n"+
                                "%s"         +
                                "--------------------------------------------------------\n" +
                                "\t%41s  $%.2f\n\n"
                        , num, nameOfCategory,listOfPurchases,"TOTAL:", sumOfCategory);
                writer.write(text);
            }

            System.out.println("\nPurchases were saved!");
        } catch (IOException e) {
            System.out.println("File not found!");
        }
    }

    public void loadFile() {
        File file = new File(filePath);
        try (Scanner importScanner = new Scanner(file)) {

            //ustawienie stanu konta:
            String[] temp = importScanner.nextLine().split("\\$");

            if (temp[1].contains(",")) {
                balance = Double.parseDouble(temp[1].replace(",", "."));
            } else {
                balance = Double.parseDouble(temp[1]);
            }

            importScanner.nextLine();

            while(importScanner.hasNextLine()) {
                //linijka z numerem i nazw�
                String[] temp1 = importScanner.nextLine().split("\\s+");
                temp1[1] = temp1[1].replace(":", "");
                int numOfCat = Integer.parseInt(temp1[0]);
                double price;
                String name;
                double sum;

                String firstLine = importScanner.nextLine();

                //je�eli dana kategoria jest pusta to id� do nast�pnej
                if (!firstLine.equals("\tThe purchase list is empty!")) {
                    //p�tla do stworzenia listy
                    while (true) {
                        if (firstLine.startsWith("\t-")) {
                            //ostatnie wyst�pienie $ oznacza pocz�tek ceny:
                            int indexLast$ = firstLine.lastIndexOf("$");

                            String reallyPrice = firstLine.substring(indexLast$ + 1);
                            String reallyName = firstLine.substring(0, indexLast$);

                            //ca�a linijka podzielona na cz�� nazwy i cz�� ceny
                            //String[] temp3 = firstLine.split("\\$");

                            //pozbawinie nazwy zb�dnych spacji
                            String[] nameWithoutSpaces = reallyName.trim().split("\\s+");

                            //cena pojedynczego produktu
                            if (reallyPrice.contains(",")) {
                                price = Double.parseDouble(reallyPrice.replace(",", "."));
                            } else {
                                price = Double.parseDouble(reallyPrice);
                            }

                            StringBuilder nameSB = new StringBuilder();
                            for (String s : nameWithoutSpaces) {
                                nameSB.append(String.format("%s ", s));
                            }

                            //nowa linijka usuni�cie pocz�tkowych my�lnik�w i dodatkowej spacji:
                            nameSB.deleteCharAt(0);
                            nameSB.deleteCharAt(0);

                            //nowa ca�a linijka (bez zb�dnych tab�w i spacji)
                            nameSB.append(String.format("$%.2f", price));
                            name = nameSB.toString();

                            //aktualizacja pierwszej linijki:
                            firstLine = importScanner.nextLine();

                            //dodaj pozycj� do listy
                            map.get(numOfCat).getBoughtProducts().add(name);
                        } else {
                            break;
                        }
                    }
                    String[] temp5 = importScanner.nextLine().split("\\$");
                    sum = Double.parseDouble(temp5[1].replace(",", "."));

                    //ustaw sum� kategorii
                    map.get(numOfCat).setSum(sum);

                    importScanner.nextLine();
                } else {
                    importScanner.nextLine();
                    importScanner.nextLine();
                    importScanner.nextLine();
                }
            }
            System.out.println("\nPurchases were loaded!");
        } catch (FileNotFoundException e) {
            System.out.println("File not found!");
        }
    }
}
