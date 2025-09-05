package com.example.singleton;

public enum Logger {
    INSTANCE;

    public static Logger getInstance() {
        return INSTANCE;
    }

    void log(String logMessage) {
        System.out.println(logMessage);
    }

}
