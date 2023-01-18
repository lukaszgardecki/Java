package com.example.textstats;

public class TextStatsDto {
    private String text;
    private Integer length;
    private Integer words;
    private Boolean palindrome;
    private String mostFamousWord;
    private Integer mostFamousWordOccurrences;

    public TextStatsDto(String text) {
        this.text = text;
    }

    public String getText() {
        return text;
    }

    public void setText(String text) {
        this.text = text;
    }

    public Integer getLength() {
        return length;
    }

    public void setLength(Integer length) {
        this.length = length;
    }

    public Integer getWords() {
        return words;
    }

    public void setWords(Integer words) {
        this.words = words;
    }

    public Boolean getPalindrome() {
        return palindrome;
    }

    public void setPalindrome(Boolean palindrome) {
        this.palindrome = palindrome;
    }

    public String getMostFamousWord() {
        return mostFamousWord;
    }

    public void setMostFamousWord(String mostFamousWord) {
        this.mostFamousWord = mostFamousWord;
    }

    public Integer getMostFamousWordOccurrences() {
        return mostFamousWordOccurrences;
    }

    public void setMostFamousWordOccurrences(Integer mostFamousWordOccurrences) {
        this.mostFamousWordOccurrences = mostFamousWordOccurrences;
    }

    @Override
    public String toString() {
        return String.format("""
                        Text: %s
                        Length: %d
                        Number of words: %d
                        Is palindrome? %s
                        The most famous word is: %s (%d)
                        """,
                text, length, words, palindrome, mostFamousWord, mostFamousWordOccurrences);
    }
}
