package pl.mojastrona.di.formatter;

import org.springframework.context.annotation.Primary;
import org.springframework.context.annotation.Profile;
import org.springframework.stereotype.Component;

@Component
@Profile("lowerCase")
public class LowerCaseTextFormatter implements TextFormatter {

    @Override
    public String format(String text) {
        return text.toLowerCase();
    }
}
