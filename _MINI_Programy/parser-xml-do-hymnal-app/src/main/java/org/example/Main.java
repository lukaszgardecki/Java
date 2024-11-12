package org.example;

import org.jdom2.Attribute;
import org.jdom2.Document;
import org.jdom2.Element;
import org.jdom2.JDOMException;
import org.jdom2.input.SAXBuilder;
import org.jdom2.output.Format;
import org.jdom2.output.XMLOutputter;

import java.io.*;
import java.util.ArrayList;
import java.util.Comparator;
import java.util.List;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class Main {
    public static void main(String[] args) {

        String plikPODSTAWOWY = "498_1.Zdrowas_Maryjo_Bogarodzico.xml";
        String plikZeSlowami = "498_1.Zdrowas_Maryjo_Bogarodzico-5.xml";

        try {
            updateSongFile(plikPODSTAWOWY, plikZeSlowami);
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    public static void updateSongFile(String file1Name, String file2Name) throws IOException, JDOMException {
        SAXBuilder saxBuilder = new SAXBuilder();
        String inputDirPath = "updater/input/";
        String outputDirPath = "updater/output/";
        String outputFilePath = outputDirPath + file1Name;
        int verseCount = Integer.parseInt(
                file2Name.substring(file2Name.lastIndexOf("-")+1).split("\\.")[0]
        );

        // Wczytanie i oczyszczenie plików XML
        String file1 = readAndCleanXML(new File(inputDirPath + file1Name));
        String file2 = readAndCleanXML(new File(inputDirPath + file2Name));

        Document mainDocument = saxBuilder.build(new StringReader(file1));
        Document lyricsDocument = saxBuilder.build(new StringReader(file2));

        boolean updated = updateNoteLyrics(mainDocument, lyricsDocument, verseCount);
        updateCreditVerses(mainDocument);
        if (updated) saveFile(outputFilePath, mainDocument);
    }



    private static boolean updateNoteLyrics(Document mainDocument, Document lyricsDocument, int verseCount) {
        // Pobierz listy nut z obu plików
        List<Element> mainNotes = getNotesFromXML(mainDocument);
        List<Element> lyricsNotes = getNotesFromXML(lyricsDocument);

//        // TA ZMIENNA NIE ZAWSZE BĘDZIE DZIAŁAĆ DOBRZE:
//        int minVerseCount = lyricsNotes.stream()
//                .map(el -> el.getChildren("lyric").size())
//                .filter(size -> size > 0)
//                .min(Integer::compareTo)
//                .orElse(1);
//
//        // ILOŚĆ SŁÓW NA PIERWSZEJ NUCIE
//        Integer verseCountFirst = lyricsNotes.stream()
//                .map(el -> el.getChildren("lyric").size())
//                .findFirst()
//                .orElseThrow();
//
//        int verseCount = verseCountFirst==1 && minVerseCount ? verseCountFirst : minVerseCount;

        if (mainNotes.size() == lyricsNotes.size()) {
            // Iteruj przez pary nut i dodaj brakujące "lyric"
            for (int i = 0; i < mainNotes.size(); i++) {
                Element mainNote = mainNotes.get(i);
                Element lyricsNote = lyricsNotes.get(i);

                // Usuń wszystkie istniejące elementy "lyric" w mainNote
                mainNote.removeChildren("lyric");

                // Pobrać nowe lyrics
                List<Element> newLyrics = lyricsNote.getChildren("lyric");
                int totalLyrics = newLyrics.size();
                int lyricsPerVerse = (totalLyrics / verseCount)==0 ? 1 : totalLyrics / verseCount;

                // Dodaj lyric do mainNote z odpowiednim numerowaniem
                for (int j = 0; j < totalLyrics; j++) {
                    Element lyricElement = newLyrics.get(j).clone();
//                    lyricElement.getChildren("text").forEach(text -> text.setText(text.getText().replaceAll("\u00A0", " ")));

                    // Oblicz, który verse i number dodać
                    int verseNumber = (j / lyricsPerVerse) + 1; // 1-indexed
                    int lyricNumber = (j % lyricsPerVerse) + 1; // 1-indexed

                    // Ustaw atrybuty verse i number
                    lyricElement.setAttribute("verse", String.valueOf(verseNumber));
                    lyricElement.setAttribute("number", String.valueOf(lyricNumber));

                    // Dodaj nowy element lyric do mainNote
                    mainNote.addContent(lyricElement);
                }
            }
        } else {
            System.out.println("Mismatch in note counts between files.");
            return false;
        }
        return true;
    }

//    public static void updateCreditVerses(Document document) {
//        Pattern versePattern = Pattern.compile("^(\\d+)\\.");
//        int currentVerse = 0;
//
//        Element root = document.getRootElement();
//        List<Element> credits = root.getChildren("credit");
//
//        for (Element credit : credits) {
//            List<Element> creditWords = credit.getChildren("credit-words");
//
//            for (int i = 0; i < creditWords.size(); i++) {
//                Element creditWord = creditWords.get(i);
//                String text = creditWord.getTextTrim();
//
//                // Usuń puste <credit-words>
//                if (text.isEmpty()) {
//                    creditWords.remove(i);
//                    i--;  // Aktualizuj indeks po usunięciu
//                    continue;
//                }
//
//                // Rozpoznaj numer zwrotki po wzorcu, np. "1."
//                Matcher matcher = versePattern.matcher(text);
//                if (matcher.find()) {
//                    currentVerse = Integer.parseInt(matcher.group(1));
//                    creditWords.remove(i);
//                    i--;
//                    continue;
//                }
//
//                // Ustaw atrybut "verse" zgodnie z numerem zwrotki
//                if (currentVerse > 0) {
//                    creditWord.setAttribute("verse", String.valueOf(currentVerse));
//                }
//
//                // Połącz tekst w jedną linię
//                creditWord.setText(text.replaceAll("\\s+", " "));
//            }
//        }
//    }


    public static void updateCreditVerses(Document document) {
        Element root = document.getRootElement();
        List<Element> rootChildren = root.getChildren();
        List<Element> credits = root.getChildren("credit");
        List<Element> newCredits = new ArrayList<>();

        int firstCreditIndex = rootChildren.stream()
                .filter(el -> el.getName().equals("credit"))
                .findFirst()
                .map(rootChildren::indexOf)
                .orElse(-1);

        for (Element credit : credits) {
            if (credit.getChild("credit-type") != null) {
                newCredits.add(credit);
                continue;
            }
            var verseCredits = divideCreditIntoVerseCredits(credit);
            newCredits.addAll(verseCredits);
        }

        root.removeChildren("credit");
        root.addContent(firstCreditIndex, newCredits);
    }

    private static List<Element> divideCreditIntoVerseCredits(Element credit) {
        Pattern versePattern = Pattern.compile("^(\\d+)\\.");
        int currentVerse = 0;
        List<Element> newCredits = new ArrayList<>();

        List<Element> creditWords = credit.getChildren("credit-words");
        for (Element creditWord : creditWords) {
            String text = creditWord
                    .getTextTrim()
                    .replaceAll("\u00A0", " ");

            if (text.isEmpty()) continue;

            // Rozpoznaj numer zwrotki po wzorcu, np. "1."
            Matcher matcher = versePattern.matcher(text);
            if (matcher.find()) {
                int newVerse = Integer.parseInt(matcher.group(1));

                // Jeżeli zwrotka się zmienia, zaktualizuj currentVerse
                if (newVerse > currentVerse) {
                    currentVerse = newVerse; // Zaktualizuj bieżący numer zwrotki
                } else {
                    // Jeśli mamy tę samą zwrotkę, po prostu pomiń.
                    continue;
                }

                Element newCredit = new Element("credit");
                credit.getAttributes().stream()
                        .map(attr -> new Attribute(attr.getName(), attr.getValue(), attr.getNamespace()))
                        .forEach(newCredit::setAttribute);
                newCredits.add(newCredit);

            } else {
                // Jeśli nie ma numeru zwrotki, dodaj do ostatniego creditu
                if (currentVerse > 0) {
                    Element lastCredit = newCredits.get(newCredits.size() - 1);

                    Element newCreditWord = new Element("credit-words");
                    newCreditWord.setText(
                            text
                                    .replaceAll("\\s+", " ")
                                    .replaceAll("\u00A0", " ")
                                    .trim()
                    );
                    creditWord.getAttributes().stream()
                            .map(attr -> new Attribute(attr.getName(), attr.getValue(), attr.getNamespace()))
                            .forEach(newCreditWord::setAttribute);

                    lastCredit.addContent(newCreditWord);
                }
            }

        }
        return newCredits;
    }

//    public static void updateCreditsForVerses(Document document) {
//        Pattern versePattern = Pattern.compile("^(\\d+)\\.");
//        int currentVerse = 0;
//
//        Element root = document.getRootElement();
//        List<Element> credits = root.getChildren("credit");
//
//        // Utwórz nową listę na elementy credit
//        List<Element> newCredits = new ArrayList<>();
//
//        for (Element credit : credits) {
//            List<Element> creditWords = credit.getChildren("credit-words");
//
//            for (Element creditWord : creditWords) {
//                String text = creditWord.getTextTrim();
//
//                // Usuń puste <credit-words>
//                if (text.isEmpty()) {
//                    continue; // Kontynuuj, nie dodawaj pustych
//                }
//
//                // Rozpoznaj numer zwrotki po wzorcu, np. "1."
//                Matcher matcher = versePattern.matcher(text);
//                if (matcher.find()) {
//                    int newVerse = Integer.parseInt(matcher.group(1));
//
//                    // Jeżeli zwrotka się zmienia, zaktualizuj currentVerse
//                    if (newVerse > currentVerse) {
//                        currentVerse = newVerse; // Zaktualizuj bieżący numer zwrotki
//                    } else {
//                        // Jeśli mamy tę samą zwrotkę, po prostu pomiń.
//                        continue;
//                    }
//
//                    // Tworzymy nowy element credit dla tej zwrotki
//                    Element newCredit = new Element("credit");
//                    newCredit.addContent(new Element("credit-words").setText(text.replaceAll("\\s+", " ").trim())
//                            .setAttribute("verse", String.valueOf(currentVerse)));
//
//                    newCredits.add(newCredit);
//                } else {
//                    // Jeśli nie ma numeru zwrotki, dodaj do ostatniego creditu
//                    if (currentVerse > 0) {
//                        Element lastCredit = newCredits.get(newCredits.size() - 1);
//                        lastCredit.addContent(new Element("credit-words").setText(text.replaceAll("\\s+", " ").trim()));
//                    }
//                }
//            }
//        }
//
//        // Usuwamy stare kredyty i dodajemy nowe
//        root.removeChildren("credit");
//        root.addContent(newCredits);
//    }


    private static List<Element> getNotesFromXML(Document document) {
        Element root = document.getRootElement();
        Element part = root.getChild("part");
        if (part != null) {
            return part.getChildren("measure")
                    .stream()
                    .flatMap(measure -> measure.getChildren("note").stream())
                    .toList();
        }
        return List.of();
    }

    private static String readAndCleanXML(File xmlFile) throws IOException {
        StringBuilder stringBuilder = new StringBuilder();

        // Odczytaj cały plik jako jeden ciąg
        try (FileReader fileReader = new FileReader(xmlFile)) {
            char[] buffer = new char[1024];
            int read;
            while ((read = fileReader.read(buffer)) != -1) {
                stringBuilder.append(buffer, 0, read);
            }
        }

        // Usuwanie deklaracji DOCTYPE
        String xmlContent = stringBuilder.toString();
        xmlContent = xmlContent.replaceAll("(?i)<!DOCTYPE.*?>", ""); // Usuń całą deklarację DOCTYPE

        return xmlContent.trim(); // Zwróć przetworzony tekst
    }

    private static void saveFile(String outputFilePath, Document mainDocument) throws IOException {
        // Zapisz zmodyfikowany plik w folderze "output"
        File outputFile = new File(outputFilePath);
        XMLOutputter xmlOutputter = new XMLOutputter();


        Format format = Format.getPrettyFormat();
        format.setLineSeparator(System.lineSeparator());
//        format.setTextMode(Format.TextMode.TRIM);
//        format.setTextMode(Format.TextMode.PRESERVE);
        xmlOutputter.setFormat(format);

        FileOutputStream outputStream = new FileOutputStream(outputFile);
        xmlOutputter.output(mainDocument, outputStream);
        outputStream.close();

        System.out.println("File saved to: " + outputFilePath);
    }
}