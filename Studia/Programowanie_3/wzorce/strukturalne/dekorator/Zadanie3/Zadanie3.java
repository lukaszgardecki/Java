package wzorce.strukturalne.dekorator.Zadanie3;

import wzorce.strukturalne.dekorator.Zadanie3.dekoratory.*;

/**
 * Zadanie 3: system logowania zdarzeń
 *
 * - zaprojektuj system logowania, w którym można dynamicznie dodawać różne kanały logowania (np. konsola, plik, baza danych, e-mail)
 * - Wymagania:
 *      - interfejs Logger z metodą void log(String message)
 *      - bazowy logger (SilentLogger)
 *      - dekoratory: ConsoleLogger, FileLogger, DatabaseLogger, EmailLogger
 * - Rozszerzenia:
 *      - dodaj dekorator TimestampLogger, któy dodaje znacznik czasu do wiadomości
 *      - dodaj dekorator LevelFilterLogger, który filtruje logi według poziomu (INFO, WARN, ERROR)
 */
public class Zadanie3 {
    public static void main(String[] args) {
        Logger logger = new LogFilterLogger(new FileLogger(new TimestampLogger(new SilentLogger())), LogLevel.WARN);

        logger.log(LogLevel.INFO, "System uruchomiony 1");
        logger.log(LogLevel.WARN, "System uruchomiony 2");
        logger.log(LogLevel.WARN, "System uruchomiony 3");
        logger.log(LogLevel.ERROR, "System uruchomiony 4");
    }
}
