package com.example.textstatistics;

import org.springframework.stereotype.Service;

import java.util.*;
import java.util.function.Function;
import java.util.stream.Collectors;

@Service
public class TextStatService {

    TextStatDto getTextStats(String text,
                             boolean length,
                             boolean words,
                             boolean palindrome,
                             boolean mostPopularWord) {
        TextStatDto textStats = new TextStatDto(text);
        if (length) {
            textStats.setLength(text.length());
        }
        if (words) {
            textStats.setWords(countWords(text));
        }
        if (palindrome) {
            textStats.setPalindrome(checkPalindrome(text));
        }
        if (mostPopularWord) {
            Map.Entry<String, Long> mostPopularWordInText = findMostPopularWord(text).get();
            textStats.setMostPopularWord(mostPopularWordInText.getKey());
            textStats.setMostPopularWordCount(mostPopularWordInText.getValue().intValue());
        }
        return textStats;
    }

    private Integer countWords(String text) {
        return text.split(" ").length;
    }

    private boolean checkPalindrome(String text) {
        String reversedText = new StringBuilder(text).reverse().toString();
        return text.equals(reversedText);
    }

    private Optional<Map.Entry<String, Long>> findMostPopularWord(String text) {
        String[] words = text.split(" ");
        return Arrays.stream(words)
                .collect(Collectors.groupingBy(Function.identity(), Collectors.counting()))
                .entrySet().stream()
                .min(Map.Entry.comparingByValue(Comparator.reverseOrder()));
    }
}
