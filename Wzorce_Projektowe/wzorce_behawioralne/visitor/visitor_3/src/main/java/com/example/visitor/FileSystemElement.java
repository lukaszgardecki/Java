package com.example.visitor;

public interface FileSystemElement {

    String getName();

    void accept(Visitor visitor);
}
