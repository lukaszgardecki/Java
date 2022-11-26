package pl.mojastrona.di.formatter;

import org.springframework.context.annotation.Profile;
import org.springframework.stereotype.Component;

@Component
@Profile("upperCase")
public class UpperCaseTextFormatter implements TextFormatter {

    @Override
    public String format(String text) {
        return text.toUpperCase();
    }
}
