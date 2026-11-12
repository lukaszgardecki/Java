package wzorce.strukturalne.dekorator.Zadanie3.dekoratory;

import wzorce.strukturalne.dekorator.Zadanie3.LogLevel;
import wzorce.strukturalne.dekorator.Zadanie3.Logger;

public class EmailLogger extends LoggerDekorator {

    public EmailLogger(Logger logger) {
        super(logger);
    }

    @Override
    public void log(LogLevel level, String message) {
        super.log(level, message);
        System.out.printf("[EMAIL] Wysłanie e-mail: %s\n", message);
    }
}
