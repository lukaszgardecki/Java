package pl.projekty.projektnowy.di;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.stereotype.Component;

import java.util.ArrayList;
import java.util.List;

@Component
public class House {
    @Autowired
    List<Window> windows;

    @Autowired
    @Qualifier("myWindows")
    public void setWindows(List<Window> windows) {
        this.windows = windows;
    }

    public void peek() {
        windows.forEach(Window::peek);
    }
}
