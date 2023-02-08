package com.example.app.spring.service;

import com.example.app.java.model.Document;
import com.example.app.java.model.Type;
import com.example.app.java.service.SearchEngine;
import com.example.app.spring.data.DocumentDAO;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;


public class SearchEngineService implements SearchEngine {

    private DocumentDAO documentDAO;
    private static final Logger log = LoggerFactory.getLogger(SearchEngineService.class);

    public SearchEngineService() {
        if (log.isDebugEnabled()) {
            log.debug("Utworzono egzemplarz klasy SearchEngineService: " + this);
        }
    }

    public DocumentDAO getDocumentDAO() {
        return documentDAO;
    }

    public void setDocumentDAO(DocumentDAO documentDAO) {
        if (log.isDebugEnabled()) {
            log.debug("Utworzono egzemplarz implementacji Document DAO: " + documentDAO);
        }
        this.documentDAO = documentDAO;
    }

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
