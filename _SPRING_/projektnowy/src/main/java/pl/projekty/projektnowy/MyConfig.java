package pl.projekty.projektnowy;

import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import pl.projekty.projektnowy.di.Weather;
import pl.projekty.projektnowy.di.Window;

import java.util.Arrays;
import java.util.List;

@Configuration
public class MyConfig {

    @Bean("myWindow")
    public Window window1(@Qualifier("sunny") Weather weather) {
        return new Window(weather);
    }

    @Bean
    public Window window2(@Qualifier("rainy") Weather weather) {
        return new Window(weather);
    }

    @Bean
    public Window window3(@Qualifier("sunny") Weather weather) {
        return new Window(weather);
    }

    @Bean("rainy")
    public Weather weather() {
        return new Weather();
    }

    @Bean
    public List<Window> myWindows(@Qualifier("sunny") Weather weather) {
        return Arrays.asList(window1(weather), window3(weather));
    }

}
