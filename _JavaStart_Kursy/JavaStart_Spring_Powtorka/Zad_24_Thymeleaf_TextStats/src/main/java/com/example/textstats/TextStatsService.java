package com.example.textstats;

import org.springframework.stereotype.Service;

import java.util.*;
import java.util.function.Function;
import java.util.stream.Collectors;

@Service
public class TextStatsService {

    private Optional<Map.Entry<String, Long>> getMostFamousWord(String text) {
        String[] words = text.split(" ");
        return Arrays.stream(words)
                .collect(Collectors.groupingBy(Function.identity(), Collectors.counting()))
                .entrySet().stream()
                .min(Map.Entry.comparingByValue(Comparator.reverseOrder()));
    }

    private Boolean isPalindrome(String text) {
        text = text.toLowerCase().replaceAll("[\s,.]", "");
        String reversedText = new StringBuilder(text).reverse().toString();
        return text.equals(reversedText);
    }

    private Integer getAmountOfWords(String text) {
        return text.split("[\n\t\s]").length;
    }

    public TextStatsDto getTextStats(String text,
                                     boolean textLength,
                                     boolean words,
                                     boolean palindrome,
                                     boolean mostFamousWord) {
        TextStatsDto dto = new TextStatsDto(text);
        if(textLength) dto.setLength(text.length());
        if(words) dto.setWords(getAmountOfWords(text));
        if(palindrome) dto.setPalindrome(isPalindrome(text));
        if(mostFamousWord) {
            Map.Entry<String, Long> mostPopularWordInText = getMostFamousWord(text).get();
            dto.setMostFamousWord(mostPopularWordInText.getKey());
            dto.setMostFamousWordOccurrences(mostPopularWordInText.getValue().intValue());
        }
        return dto;
    }
}
