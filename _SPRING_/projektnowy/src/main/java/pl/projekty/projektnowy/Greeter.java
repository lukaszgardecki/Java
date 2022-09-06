package pl.projekty.projektnowy;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.ApplicationArguments;
import org.springframework.boot.ApplicationRunner;
import org.springframework.stereotype.Component;
import pl.projekty.projektnowy.di.House;

@Component
public class Greeter implements ApplicationRunner {

    @Autowired
    House house;

    @Override
    public void run(ApplicationArguments args) throws Exception {
        System.out.println("-=-=-=-=-=-=-=-");
        house.peek();
        System.out.println("-=-=-=-=-=-=-=-");
    }
}
