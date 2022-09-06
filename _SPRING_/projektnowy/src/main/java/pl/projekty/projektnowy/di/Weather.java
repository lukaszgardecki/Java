package pl.projekty.projektnowy.di;

import org.springframework.stereotype.Component;

import java.util.Random;

@Component("sunny")
public class Weather {
    private static final Random random = new Random();
    public String description;

    public Weather() {
        int i = random.nextInt(3)%3;

        chooseWeather(i);
    }

    public Weather(int i) {
        chooseWeather(i);
    }

    private void chooseWeather(int i) {
        switch (i) {
            case 0:
                description = "Swieci slonce";
                break;
            case 1:
                description = "Pada deszcz";
                break;
            case 2:
                description = "Wieje mocny wiatr";
                break;
        }
    }
}
