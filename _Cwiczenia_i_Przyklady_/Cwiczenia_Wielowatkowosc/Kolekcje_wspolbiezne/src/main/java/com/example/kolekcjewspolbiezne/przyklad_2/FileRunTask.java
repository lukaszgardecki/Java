package com.example.kolekcjewspolbiezne.przyklad_2;

import java.io.File;
import java.util.concurrent.BlockingQueue;

public class FileRunTask implements Runnable {
    public static final File EXIT = new File("");
    private BlockingQueue<File> que;
    private File startDir;

    public FileRunTask(BlockingQueue<File> que, File startDir) {
        this.que = que;
        this.startDir = startDir;
    }

    @Override
    public void run() {
        try {
            runDir(startDir);
            que.put(EXIT);
        } catch(InterruptedException ex) {
            ex.printStackTrace();
        }
    }

    public void  runDir(File dir) throws InterruptedException {
        File[] files = dir.listFiles();
        for (File ff: files) {
            if (ff.isDirectory()) {
                runDir(ff);
            } else {
                que.put(ff);
            }
        }
    }
}
