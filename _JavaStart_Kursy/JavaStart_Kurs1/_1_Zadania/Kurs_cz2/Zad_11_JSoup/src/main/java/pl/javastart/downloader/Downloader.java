package pl.javastart.downloader;

import org.jsoup.Jsoup;
import org.jsoup.nodes.Document;
import org.jsoup.nodes.Element;
import org.jsoup.select.Elements;

import java.io.IOException;

public class Downloader {
    public static void main(String[] args) throws IOException {
        Document document = Jsoup.connect("https://wykop.pl").get();

        // pobierz wszystkie nagłówki H2
        Elements elements = document.select("h2");


        for (Element h2 : elements) {
            String h2Url = h2.select("a").first().attr("href");
            String h2Text = h2.text();
            System.out.println(h2Text + " ::: " + h2Url);
        }

    }

}
