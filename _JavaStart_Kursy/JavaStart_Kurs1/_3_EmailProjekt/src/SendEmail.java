import org.apache.commons.mail.DefaultAuthenticator;
import org.apache.commons.mail.Email;
import org.apache.commons.mail.EmailException;
import org.apache.commons.mail.SimpleEmail;

public class SendEmail {
    public static void main(String[] args) throws EmailException {


        Email email = new SimpleEmail();
        //Ustawienie serwera poczty wychodz¹cej (SMTP), ka¿da ma inn¹:
        email.setHostName("poczta.interia.pl");
        //Ustawienie portu
        email.setSmtpPort(587);
        email.setAuthenticator(new DefaultAuthenticator("konto.testowe100", "test12345"));
        email.setSSLOnConnect(true);
        //email, z którego wysy³amy
        email.setFrom("konto.testowe100@interia.pl");
        //ustawienie Tematu
        email.setSubject("TestMail");
        //Wiadomoœæ:
        email.setMsg("To jest wiadomoœæ testowa !");
        //email odbiorcy
        email.addTo("lukas.g1804@gmail.com");

        System.out.println("Rozpoczêto wysy³anie wiadomoœci email.");
        email.send();
        System.out.println("Wiadomoœæ wys³ana.");
    }
}
