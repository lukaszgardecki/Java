package com.example.app.java.service;

import com.example.app.java.model.Document;
import com.example.app.java.model.Type;

import java.util.List;

public interface SearchEngine {
    List<Document> findByType(Type documentType);
    List<Document> listAll();
}
