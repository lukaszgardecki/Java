package com.example.singleton;

public class ImagePrinter {

    public void printImage() {
        var spooler = PrintSpooler.getInstance();
        spooler.print();
    }

}
