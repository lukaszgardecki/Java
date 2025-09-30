package com.example.kolekcjewspolbiezne.przyklad_2;

import java.io.File;
import java.io.IOException;
import java.util.Scanner;
import java.util.concurrent.BlockingQueue;

public class SearchTask implements Runnable {
    private BlockingQueue<File> que;
    private String word;

    SearchTask(BlockingQueue<File> que, String word) {
        this.que = que;
        this.word = word;
    }

    public void search(File ff) throws IOException {
        try(Scanner sc = new Scanner(ff)) {
            while(sc.hasNextLine()) {
                String str = sc.nextLine();
                if(str.contains(word)) {
                    System.out.println(ff.getPath() + " -> " + str);
                }
            }
        }
    }

    @Override
    public void run() {
        try {
            while (true) {
                File ff = que.take();
                if (ff == FileRunTask.EXIT) {
                    que.put(ff);
                    break;
                } else {
                    search(ff);
                }
            }
        } catch (IOException | InterruptedException e) {
            e.printStackTrace();
        }
    }
}