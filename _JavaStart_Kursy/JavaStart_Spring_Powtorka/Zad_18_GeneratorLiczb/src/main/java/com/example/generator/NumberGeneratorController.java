package com.example.generator;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;

import java.util.stream.Collectors;

@Controller
public class NumberGeneratorController {
    private final NumberService numberService;

    public NumberGeneratorController(NumberService numberService) {
        this.numberService = numberService;
    }

    @GetMapping("/random")
    @ResponseBody
    String getRandomNumber(@RequestParam(required = false) Integer from,
                           @RequestParam(required = false) Integer to) {

        Integer downBound;
        Integer upBound;
        try {
            downBound = getDownBound(from, to);
            upBound = getUpBound(from, to);
        } catch (DownBoundIsGreaterThenUpException e) {
            return e.getMessage();
        }
        int randomNum = numberService.getRandomNumberFromRange(downBound, upBound);
        return String.format("Losowa liczba z przedziału [%s; %s]: %s", downBound, upBound, randomNum);
    }

    @GetMapping("/even-numbers")
    @ResponseBody
    String getEvenNumbers(@RequestParam(required = false) Integer from,
                          @RequestParam(required = false) Integer to) {
        Integer downBound;
        Integer upBound;
        try {
            downBound = getDownBound(from, to);
            upBound = getUpBound(from, to);
        } catch (DownBoundIsGreaterThenUpException e) {
            return e.getMessage();
        }
         return numberService.getEvenNumbersFromRange(downBound, upBound)
                .stream()
                .map(String::valueOf)
                .collect(Collectors.joining(", "));
    }

    @GetMapping("/odd-numbers")
    @ResponseBody
    String getOddNumbers(@RequestParam(required = false) Integer from,
                         @RequestParam(required = false) Integer to) {
        Integer downBound;
        Integer upBound;
        try {
            downBound = getDownBound(from, to);
            upBound = getUpBound(from, to);
        } catch (DownBoundIsGreaterThenUpException e) {
            return e.getMessage();
        }
        return numberService.getOddNumbersFromRange(downBound, upBound)
                .stream()
                .map(String::valueOf)
                .collect(Collectors.joining(", "));
    }

    private Integer getDownBound(Integer from, Integer to) throws DownBoundIsGreaterThenUpException {
        return getBounds(from, to)[0];
    }

    private Integer getUpBound(Integer from, Integer to) throws DownBoundIsGreaterThenUpException {
        return getBounds(from, to)[1];
    }

    private Integer[] getBounds(Integer from, Integer to) {
        if (from == null && to == null) {
            from = 0;
            to = 1000;
        } else if (from == null) {
            from = to - 100;
        } else if (to == null) {
            to = from + 100;
        } else if (from > to) {
            throw new DownBoundIsGreaterThenUpException();
        }
        return new Integer[]{from, to};
    }
}
