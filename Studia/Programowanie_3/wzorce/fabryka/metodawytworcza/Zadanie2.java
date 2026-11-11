package wzorce.fabryka.metodawytworcza;

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
        EmailNotificationFactory emailFactory = new EmailNotificationFactory();
        Notification email = emailFactory.createNotification();
        email.send("Witaj w systemie!");

        SmsNotificationFactory smsFactory = new SmsNotificationFactory();
        Notification sms = smsFactory.createNotification();
        sms.send("Twoje hasło zostało wysłane");

        PushNotificationFactory pushFactory = new PushNotificationFactory();
        Notification push = pushFactory.createNotification();
        push.send("Coś wysłane przez push");

        SlackNotificationFactory slackFactory = new SlackNotificationFactory();
        Notification slack = slackFactory.createNotification();
        slack.send("Wiadomość przez slacka");
    }
}

//enum NotificationType { EMAIL, SMS, PUSH, SLACK }

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



// FABRYKI

abstract class NotificationFactory {
    abstract Notification createNotification();
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



// POWIADOMIENIA

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

