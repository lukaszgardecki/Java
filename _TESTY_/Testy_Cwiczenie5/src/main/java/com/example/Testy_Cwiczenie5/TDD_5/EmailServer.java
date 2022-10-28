package com.example.Testy_Cwiczenie5.TDD_5;

public interface EmailServer {
    void send(String template, String distributionList, String[] params);
}
