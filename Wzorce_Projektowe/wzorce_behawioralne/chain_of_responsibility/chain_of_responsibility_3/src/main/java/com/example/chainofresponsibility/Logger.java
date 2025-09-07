package com.example.chainofresponsibility;

public abstract class Logger {
    public final Logger nextLogger;

    public Logger(Logger nextLogger) {
        this.nextLogger = nextLogger;
    }

    public abstract void log(LoggerRequest request);

}
