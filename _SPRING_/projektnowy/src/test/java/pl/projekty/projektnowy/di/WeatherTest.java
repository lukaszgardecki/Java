package pl.projekty.projektnowy.di;


import org.junit.Assert;
import org.junit.Test;

public class WeatherTest{

    @Test
    public void testWeatherMod0() {
        Weather w = new Weather(0);
        Assert.assertEquals("Swieci slonce", w.description);
    }

    @Test
    public void testWeatherMod0Neg() {
        Weather w = new Weather(0);
        Assert.assertNotEquals("Swieci            slonce", w.description);
    }
}
