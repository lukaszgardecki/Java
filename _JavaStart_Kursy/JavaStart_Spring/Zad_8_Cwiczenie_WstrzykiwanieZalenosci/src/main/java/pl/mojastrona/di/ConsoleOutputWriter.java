package pl.mojastrona.di;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import pl.mojastrona.di.formatter.TextFormatter;

@Service
class ConsoleOutputWriter {
    private final TextFormatter textFormatter;

    @Autowired
    public ConsoleOutputWriter(TextFormatter textFormatter) {
        this.textFormatter = textFormatter;
    }

    void println(String text) {
        String formattedText = textFormatter.format(text);
        System.out.println(formattedText);
    }
}
