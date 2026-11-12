package wzorce.strukturalne.dekorator.Zadanie3.dekoratory;

import wzorce.strukturalne.dekorator.Zadanie3.LogLevel;
import wzorce.strukturalne.dekorator.Zadanie3.Logger;

abstract class LoggerDekorator implements Logger {
    protected Logger opakowanyLogger;

    public  LoggerDekorator(Logger logger) {
        this.opakowanyLogger = logger;
    }

    @Override
    public void log(LogLevel level, String message) {
        opakowanyLogger.log(level, message);
    }
}
