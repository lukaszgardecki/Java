package wzorce.strukturalne.dekorator.Zadanie3.dekoratory;

import wzorce.strukturalne.dekorator.Zadanie3.LogLevel;
import wzorce.strukturalne.dekorator.Zadanie3.Logger;

public class LogFilterLogger extends LoggerDekorator {
    private final LogLevel level;

    public LogFilterLogger(Logger logger, LogLevel level) {
        super(logger);
        this.level = level;
    }

    @Override
    public void log(LogLevel level, String message) {
        if (level == this.level) {
            super.log(level, message);
        }
    }
}
