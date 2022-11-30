package com.example.texttables;

import com.github.freva.asciitable.AsciiTable;

public class TableGeneratorService {
    public static final String DATA_SEPARATOR = ";";

    public static String getTextTable(String[] headers, String[][] data) {
        return AsciiTable.getTable(headers, data);
    }
}
