package com.example.formatterkodu;

import com.google.googlejavaformat.java.Formatter;
import com.google.googlejavaformat.java.FormatterException;
import org.springframework.stereotype.Service;

@Service
public class CodeFormatService {

    String format(String source) throws FormatterException {
        return new Formatter().formatSource(source);
    }
}
