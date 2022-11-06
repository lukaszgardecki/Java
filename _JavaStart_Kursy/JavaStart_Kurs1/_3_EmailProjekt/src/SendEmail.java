import org.apache.commons.mail.DefaultAuthenticator;
import org.apache.commons.mail.Email;
import org.apache.commons.mail.EmailException;
import org.apache.commons.mail.SimpleEmail;

public class SendEmail {
    public static void main(String[] args) throws EmailException {


        Email email = new SimpleEmail();
        //Ustawienie serwera poczty wychodz�cej (SMTP), ka�da ma inn�:
        email.setHostName("poczta.interia.pl");
        //Ustawienie portu
        email.setSmtpPort(587);
        email.setAuthenticator(new DefaultAuthenticator("konto.testowe100", "test12345"));
        email.setSSLOnConnect(true);
        //email, z kt�rego wysy�amy
        email.setFrom("konto.testowe100@interia.pl");
        //ustawienie Tematu
        email.setSubject("TestMail");
        //Wiadomo��:
        email.setMsg("To jest wiadomo�� testowa !");
        //email odbiorcy
        email.addTo("lukas.g1804@gmail.com");

        System.out.println("Rozpocz�to wysy�anie wiadomo�ci email.");
        email.send();
        System.out.println("Wiadomo�� wys�ana.");
    }
}
