package wzorce.strukturalne.dekorator.Zadanie3;

public class SilentLogger implements Logger {
    @Override
    public void log(LogLevel level, String message) {
        // nic nie robi skoro "silent"
    }
}
