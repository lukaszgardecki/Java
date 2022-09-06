package pl.projekty.projektnowy.di;

import org.junit.After;
import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;

import java.io.ByteArrayOutputStream;
import java.io.PrintStream;

public class WindowTest {

    private final PrintStream originalOut = System.out;
    private final ByteArrayOutputStream customOut = new ByteArrayOutputStream();

    @Before
    public void setUp() {
        System.setOut(new PrintStream(customOut));
    }

    @Test
    public void testWindowOneWeather() {
        Weather weather = new Weather(0);
        Window window = new Window(weather);
        window.peek();
        Assert.assertEquals("Swieci slonce" + System.lineSeparator(), customOut.toString());

    }

    @After
    public void cleanUp() {
        System.setOut(new PrintStream(originalOut));
    }
}
