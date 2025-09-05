package com.example.singleton;


/**
 * Użycie enuma zamiast "final class" zapewnia że ten singleton jest bezpieczny wątkowo
 */
public enum PrintSpooler {
    INSTANCE;

    PrintSpooler() {}

    public static PrintSpooler getInstance() {
        return INSTANCE;
    }

    void print() {
        System.out.println("Printing...");
    }
}
