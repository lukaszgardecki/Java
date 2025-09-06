package com.example.adapter;

public class App {

    public static void main(String[] args) {
        var pdfDocumentUploader = new PdfDocumentUploader();
        var onlineApplication = new OnlineApplication(pdfDocumentUploader);
        onlineApplication.uploadDocument();

        WordDocumentAdapter wordDocumentAdapter = new WordDocumentAdapter();
        OnlineApplication onlineApplication1 = new OnlineApplication(wordDocumentAdapter);
        onlineApplication1.uploadDocument();
    }

}
