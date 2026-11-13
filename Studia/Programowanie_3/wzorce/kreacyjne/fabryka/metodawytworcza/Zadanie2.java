package wzorce.kreacyjne.fabryka.metodawytworcza;

import java.util.HashMap;
import java.util.Map;
import java.util.function.Supplier;

/**
 * Zadanie 2: System powiadomień
 *
 * Cel: zrozumienie, jak fabryka może ukrywać szczegóły implementacji i zwracać obiekty przez wspólny interfejs Notification
 *
 * - Utwórz fabrykę NotificationFactory, która zwraca różne typy powiadomień (EmailNotification, SMSNotification, PushNotification), wypisując tekst powiadomienia na konsolę
 * - Rozszerzenie: dodaj możliwość dynamicznej rejestracji nowych typów powiadomień (np. SlackNotification)
 */
public class Zadanie2 {

    public static void main(String[] args) {
//        Notification n1 = NotificationFactory.createNotification(NotificationType.EMAIL);
//        Notification n2 = NotificationFactory.createNotification(NotificationType.SMS);

//        n1.send("Witaj w systemie!");
//        n2.send("Twoje hasło zostało zmienione.");


        //Rozszerzenie - metoda wytwórcza:
        NotificationFactory.registerFactory(NotificationType.EMAIL, EmailNotificationFactory::new);
        NotificationFactory.registerFactory(NotificationType.SMS, SmsNotificationFactory::new);
        NotificationFactory.registerFactory(NotificationType.PUSH, PushNotificationFactory::new);
        NotificationFactory.registerFactory(NotificationType.SLACK, SlackNotificationFactory::new);

        Notification notifiaction;

        notifiaction = NotificationFactory.getFactory(NotificationType.EMAIL).createNotification();
        notifiaction.send("Witaj w systemie!");

        notifiaction = NotificationFactory.getFactory(NotificationType.SMS).createNotification();
        notifiaction.send("Twoje hasło zostało wysłane");

        notifiaction = NotificationFactory.getFactory(NotificationType.PUSH).createNotification();
        notifiaction.send("Coś wysłane przez push");

        notifiaction = NotificationFactory.getFactory(NotificationType.SLACK).createNotification();
        notifiaction.send("Wiadomość przez slacka");
    }
}

enum NotificationType { EMAIL, SMS, PUSH, SLACK }

//class NotificationFactory {
//    static Notification createNotification(NotificationType type) {
//        return switch(type) {
//            case EMAIL -> new EmailNotification();
//            case SMS -> new SMSNotification();
//            case PUSH -> new PushNotification();
//            case SLACK -> new SlackNotification();
//        }
//    }
//}



// FABRYKI - Twórcy - Kreatorzy

abstract class NotificationFactory {
    private static final Map<NotificationType, Supplier<NotificationFactory>> fabryki = new HashMap<>();

    abstract Notification createNotification();

    public static void registerFactory(NotificationType type, Supplier<NotificationFactory> supplier) {
        fabryki.put(type, supplier);
    }

    public static NotificationFactory getFactory(NotificationType type) {
        Supplier<NotificationFactory> fabryka = fabryki.get(type);
        if (fabryka == null) {
            throw new IllegalArgumentException("Brak fabryki dla typu: " + type);
        }
        return fabryka.get();
    }
}

class EmailNotificationFactory extends NotificationFactory {
    @Override
    public Notification createNotification() {
        return new EmailNotification();
    }
}

class SmsNotificationFactory extends NotificationFactory {
    @Override
    public Notification createNotification() {
        return new SMSNotification();
    }
}

class PushNotificationFactory extends NotificationFactory {
    @Override
    public Notification createNotification() {
        return new PushNotification();
    }
}

class SlackNotificationFactory extends NotificationFactory {
    @Override
    public Notification createNotification() {
        return new SlackNotification();
    }
}



// POWIADOMIENIA - konkretne elementy tworzone

interface Notification {
    void send(String message);
}

class EmailNotification implements Notification {
    @Override
    public void send(String message) {
        System.out.println("Wysyłam e-mail: " + message);
    }
}

class SMSNotification implements Notification {
    @Override
    public void send(String message) {
        System.out.println("Wysyłam SMS: " + message);
    }
}

class PushNotification implements Notification {
    @Override
    public void send(String message) {
        System.out.println("Wysyłam push: " + message);
    }
}

class SlackNotification implements Notification {
    @Override
    public void send(String message) {
        System.out.println("Wysyłam slack: " + message);
    }
}

