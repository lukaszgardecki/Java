package pl.projekty.projektnowy.di;

public class Window {

    Weather weather;

    public Window(Weather weather) {
        this.weather = weather;
    }


    public void peek() {
        System.out.println(weather.description);
    }
}
