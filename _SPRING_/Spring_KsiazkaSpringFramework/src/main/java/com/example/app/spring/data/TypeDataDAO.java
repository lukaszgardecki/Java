package com.example.app.spring.data;

import com.example.app.java.model.Type;

public interface TypeDataDAO {
    Type[] getAll();

    Type findById(String id);
}
