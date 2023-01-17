package com.example.tables;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;

@Controller
public class TableController {

    @PostMapping("/table")
    @ResponseBody
    String table(@RequestParam String headersString,
                 @RequestParam String dataString) {
        return TableService.getTable(headersString, dataString);
    }
}
