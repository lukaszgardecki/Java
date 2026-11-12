package wzorce.strukturalne.dekorator.Zadanie3.dekoratory;

import wzorce.strukturalne.dekorator.Zadanie3.LogLevel;
import wzorce.strukturalne.dekorator.Zadanie3.Logger;

public class ConsoleLogger extends LoggerDekorator {

    public ConsoleLogger(Logger logger) {
        super(logger);
    }

    @Override
    public void log(LogLevel level, String message) {
        super.log(level, message);
        System.out.printf("[CONSOLE] %s\n", message);
    }
}
