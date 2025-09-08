package com.example.memento;

public class DocumentViewer {

    public static void main(String[] args) {
        var textDocument = new TextDocument();
        textDocument.write("Hello, world! ");
        textDocument.save();
        textDocument.print();
        textDocument.write("How are you?");
        textDocument.print();
        textDocument.undo();
        textDocument.print();
    }

}
