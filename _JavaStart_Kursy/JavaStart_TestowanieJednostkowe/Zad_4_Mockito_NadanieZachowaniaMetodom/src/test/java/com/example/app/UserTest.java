package com.example.app;

import org.assertj.core.api.Assertions;
import org.junit.jupiter.api.Test;
import org.mockito.ArgumentMatcher;
import org.mockito.ArgumentMatchers;
import org.mockito.Mockito;

import static org.assertj.core.api.Assertions.*;
import static org.junit.jupiter.api.Assertions.*;

class UserTest {

    /**
     * Mo¿na to zobrazowaæ w ten sposób, ¿e nadajemy instrukcjê mockowi:
     * "S³uchaj. Jeœli ktoœ Ciê zapyta to zapyta o tê metodê, to odpowiedz mu w ten sposób".
     *
     * Od tego momentu ka¿de wywo³anie metody spowoduje zwrócenie zadanej wartoœci.
     */
    @Test
    public void shouldAlwaysReturnGivenName() {
        User user = Mockito.mock(User.class);

        Mockito.when(user.getName()).thenReturn("Kasia");

        assertThat(user.getName()).isEqualTo("Kasia");
        assertThat(user.getName()).isEqualTo("Kasia");
        assertThat(user.getName()).isEqualTo("Kasia");

    }

    /**
     * Istnieje mo¿liwoœæ podania kilku wartoœci. W takim przypadku definiujemy co ma byæ zwrócone
     * za pierwszym razem, co za drugim i kolejnym.
     * Ostatnia wartoœæ bêdzie zwracana dla ka¿dego kolejnego wywo³ania.
     */

    @Test
    public void shouldAlwaysReturnGivenName2() {
        User user = Mockito.mock(User.class);

        Mockito.when(user.getName()).thenReturn("Kasia", "Basia", "Krysia");

        assertThat(user.getName()).isEqualTo("Kasia");
        assertThat(user.getName()).isEqualTo("Basia");
        assertThat(user.getName()).isEqualTo("Krysia");
        assertThat(user.getName()).isEqualTo("Krysia");
        assertThat(user.getName()).isEqualTo("Krysia");
        assertThat(user.getName()).isEqualTo("Krysia");

    }

    @Test
    public void shouldAlwaysReturnGivenName3() {
        User user = Mockito.mock(User.class);

        Mockito.when(user.getName()).then(i -> {
            System.out.println("Liczenie wartoœci wynikowej");
            return "Kasia";
        });

        assertThat(user.getName()).isEqualTo("Kasia");
        assertThat(user.getName()).isEqualTo("Basia");
        assertThat(user.getName()).isEqualTo("Krysia");
        assertThat(user.getName()).isEqualTo("Krysia");
        assertThat(user.getName()).isEqualTo("Krysia");
        assertThat(user.getName()).isEqualTo("Krysia");

    }

    /**
     * G³owna ró¿nica miêdzy thenReturn(), a then() polega na tym kiedy nastêpuje ewaluacja wyniku.
     * W pierwszym przypadku jest to w momencie deklaracji, natomiast w drugim wywo³anie metody nast¹pi
     * dopiero wtedy kiedy bêdzie ona potrzebna.
     */


    /**
     * Przydatn¹ funkcjonalnoœci¹ jest mo¿liwoœæ nakazania mockowi rzucenie wyj¹tku. S³u¿y do
     * tego metoda thenThrow(Throwable... t)  . Poni¿szy test nie przejdzie z powodu wyj¹tku,
     * który zostanie rzucony przy wywo³aniu user.getName()
     */
    @Test
    public void shouldThrowExceptionOnGetter() {
        User user = Mockito.mock(User.class);
        Mockito.when(user.getName()).thenThrow(new NullPointerException());

        assertThat(user.getName());
    }

    /**
     * W przypadku metod, które zwracaj¹ void powy¿sza metoda nie zadzia³a.
     * Wynika to z tego jak w Javie obs³ugiwany jest typ void. W takim przypadku nale¿y u¿yæ jej odpowiednika Mockito.doThrow()
     */

    @Test
    public void shouldHandleVoidMethod() {
        User user = Mockito.mock(User.class);

        Mockito.doThrow(new IllegalStateException()).when(user).setName("Kasia");

        user.setName("Basia"); // <-- powiedzie siê test
        user.setName("Kasia"); // <-- dopiero tu zostanie wyrzucony wyj¹tek
    }

    /**
     * Jednak gdybyœmy chcieli, ¿eby wyj¹tek by³ rzucony dla ka¿dego argumentu nale¿y u¿yæ ArgumentMatchera:
     */
    @Test
    public void shouldHandleVoidMethod2() {
        User user = Mockito.mock(User.class);

        Mockito.doThrow(new IllegalStateException()).when(user).setName(ArgumentMatchers.anyString());

        user.setName("Basia"); // <-- zostanie wyrzucony wyj¹tek
        user.setName("Kasia"); // <-- zostanie wyrzucony wyj¹tek
    }


}