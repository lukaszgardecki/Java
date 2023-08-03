package optionals;

import java.util.Optional;

public class Main {
    public static void main(String[] args) {

        String em = "john@gmail.com";
        Optional.ofNullable(null)
                .ifPresentOrElse(email -> System.out.println("Sending email to " + email),
                        () -> System.out.println("Cannot send email"));

    }
}
