package Zad_72_Lambdy3;

import java.util.ArrayList;
import java.util.List;
import java.util.function.Consumer;
import java.util.function.Predicate;

class EmailManager {
    public static void main(String[] args) {
        List<Email> emailList = createEmailList();

        System.out.println(">>> Wys³ane maile:");
        List<Email> sentEmails = filterEmails(emailList, email -> email.isSent());
        displayEmails(sentEmails, email -> System.out.println(email));

        System.out.println(">>> Maile przefiltrowane na podstawie nadawcy lub odbiorcy");
        String mail = "joe@example.com";
        List<Email> bartEmails = filterEmails(emailList, email -> email.getRecipient().equals(mail) ||
                                                                  email.getSender().equals(mail));
        displayEmails(bartEmails, email -> System.out.println(email));
    }

    private static <T> void displayEmails(List<T> sentEmails, Consumer<T> consumer) {
        for (T em : sentEmails) {
            consumer.accept(em);
        }
    }

    private static <T> List<T> filterEmails(List<T> emailList, Predicate<T> predicate) {
        List<T> list = new ArrayList<>();
        for (T email : emailList) {
            if (predicate.test(email)) {
                list.add(email);
            }
        }
        return list;
    }

    private static List<Email> createEmailList() {
        List<Email> emails = new ArrayList<>();
        emails.add(new Email(
                "joe@example.com",
                "barbara@example.com",
                "Kup bu³ki",
                "Czeœæ!, Kup proszê bu³ki, gdy bêdziesz wracaæ z pracy.",
                false)
        );
        emails.add(new Email(
                "carl@example.com",
                "joe@example.com",
                "Nowa inwestycja",
                "Siema! Musimy omówiæ temat nowej inwestycji, pasuje Ci jutro?",
                true)
        );
        emails.add(new Email(
                "joe@example.com",
                "bart@example.com",
                "Wypad na miasto",
                "Czeœæ. Idziemy dzisiaj wieczorem z ch³opakami na miasto. Do³¹czasz do nas?",
                true)
        );
        return emails;
    }
}
