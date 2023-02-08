package com.example.app.spring.annotated.service;

import com.example.app.java.model.Document;
import com.example.app.java.model.Type;
import com.example.app.java.service.SearchEngine;
import com.example.app.spring.data.DocumentDAO;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Scope;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

@Service()
@Scope("prototype")
public class AnnotatedSearchEngine implements SearchEngine {
    @Autowired
    private DocumentDAO documentDAO;

    @Override
    public List<Document> findByType(Type documentType) {
        List<Document> result = new ArrayList<>();
        for (Document document : listAll()) {
            if (document.getType().getName().equals(documentType.getName())) {
                result.add(document);
            }
        }
        return result;
    }

    @Override
    public List<Document> listAll() {
        return Arrays.asList(documentDAO.getAll());
    }
}
