package com.example.texttables;

import com.github.freva.asciitable.AsciiTable;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;

@Controller
public class TableController {


    @PostMapping(path = "/generate", produces = "text/plain")
    @ResponseBody
    String createTable(@RequestParam String headers, @RequestParam String data) {
        String[] headersArray = headers.split(TableGeneratorService.DATA_SEPARATOR);
        String[] dataArray = data.split("\n");

        String[][] table = new String[dataArray.length][];

        for (int i = 0; i < dataArray.length; i++) {
            table[i] = dataArray[i].split(TableGeneratorService.DATA_SEPARATOR);
        }
        return TableGeneratorService.getTextTable(headersArray, table);
    }

}
