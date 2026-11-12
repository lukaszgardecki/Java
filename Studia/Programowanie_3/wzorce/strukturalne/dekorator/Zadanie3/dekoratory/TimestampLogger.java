package wzorce.strukturalne.dekorator.Zadanie3.dekoratory;

import wzorce.strukturalne.dekorator.Zadanie3.LogLevel;
import wzorce.strukturalne.dekorator.Zadanie3.Logger;

import java.time.LocalDateTime;

public class TimestampLogger extends LoggerDekorator {

    public TimestampLogger(Logger logger) {
        super(logger);
    }

    @Override
    public void log(LogLevel level, String message) {
        super.log(level, message);
        System.out.printf("LOG: [%s] %s\n", LocalDateTime.now(),  message);
    }
}
