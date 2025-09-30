package com.example.kolekcjewspolbiezne.przyklad_2;

import java.io.File;
import java.util.Scanner;
import java.util.concurrent.ArrayBlockingQueue;
import java.util.concurrent.BlockingQueue;

public class BlockingQueueDemo {
    public static void main(String[] args) {

        // określamy lokalizację folderu oraz słowo kluczowe (input użytkownika)
        Scanner sc = new Scanner(System.in);
        System.out.print("Enter directiry -> ");
        String dir = sc.next();
        System.out.print("Enter keyWord -> ");
        String word = sc.next();

        // tworzymy pustą kolejkę blokującą o rozmiarze 10
        BlockingQueue<File> que = new ArrayBlockingQueue<>(10);

        // startujemy 1 wątek wykonujący FileRunTask
        new Thread(new FileRunTask(que, new File(dir))).start();

        // startujemy 50 wątków wykonujących SearchTask
        for (int i = 0; i < 50; i++) {
            new Thread(new SearchTask(que, word)).start();
        }
    }
}
