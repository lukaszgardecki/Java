package com.example.tables;

import com.github.freva.asciitable.AsciiTable;

import java.util.Scanner;

public class TableService {
    private static final String DELIMITER = ";";

    static String getTable(String headersString, String dataString) {
        String[] headers = getHeaders(headersString);
        String[][] data = getData(dataString);
        String table = AsciiTable.getTable(headers, data);
        String htmlTable = "<pre>" + table + "</pre>";
        return htmlTable;
    }

    private static String[] getHeaders(String headersString) {
        return headersString.split(DELIMITER);
    }

    private static String[][] getData(String dataString) {
        Scanner scanner = new Scanner(dataString);
        int lines = dataString.lines().toList().size();
        String[][] table = new String[lines][];

        for (int i = 0; i < lines; i++) {
            table[i] = scanner.nextLine().split(DELIMITER);
        }
        scanner.close();
        return table;
    }
}
