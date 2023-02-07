package com.example.app.service;

import com.example.app.model.Document;
import com.example.app.model.Type;

import java.util.List;

public interface SearchEngine {
    List<Document> findByType(Type documentType);
    List<Document> listAll();
}
