package wzorce.dekorator.Zadanie3.dekoratory;

import wzorce.dekorator.Zadanie3.LogLevel;
import wzorce.dekorator.Zadanie3.Logger;

public class FileLogger extends LoggerDekorator {

    public FileLogger(Logger logger) {
        super(logger);
    }

    @Override
    public void log(LogLevel level, String message) {
        super.log(level, message);
        System.out.printf("[FILE] Zapis od pliku: %s\n", message);
    }
}
