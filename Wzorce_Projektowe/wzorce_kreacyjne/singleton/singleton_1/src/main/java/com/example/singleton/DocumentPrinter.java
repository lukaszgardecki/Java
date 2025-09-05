package com.example.singleton;

public class DocumentPrinter {

    public void printDocument() {
        var spooler = PrintSpooler.getInstance();
        spooler.print();
    }



}
