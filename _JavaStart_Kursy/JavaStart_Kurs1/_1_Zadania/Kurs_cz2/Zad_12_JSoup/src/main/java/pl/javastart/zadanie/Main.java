package pl.javastart.zadanie;

import org.jsoup.Jsoup;
import org.jsoup.nodes.Document;
import org.jsoup.nodes.Element;
import org.jsoup.select.Elements;

import java.io.IOException;
import java.util.Objects;

public class Main {
    public static void main(String[] args) throws IOException {
        Document document = Jsoup.connect("https://example.com").get();

        Elements h1Elements = document.select("h1");
        Elements pElements = document.select("p");

        String h1 = h1Elements.first().text();
        String p = pElements.first().text();

        System.out.println("Zawartość paragrafu p: " + p);
        System.out.println("Zawartość nagłówka h1: " + h1);

    }
}
