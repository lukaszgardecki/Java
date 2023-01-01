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
     * Mo�na to zobrazowa� w ten spos�b, �e nadajemy instrukcj� mockowi:
     * "S�uchaj. Je�li kto� Ci� zapyta to zapyta o t� metod�, to odpowiedz mu w ten spos�b".
     *
     * Od tego momentu ka�de wywo�anie metody spowoduje zwr�cenie zadanej warto�ci.
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
     * Istnieje mo�liwo�� podania kilku warto�ci. W takim przypadku definiujemy co ma by� zwr�cone
     * za pierwszym razem, co za drugim i kolejnym.
     * Ostatnia warto�� b�dzie zwracana dla ka�dego kolejnego wywo�ania.
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
            System.out.println("Liczenie warto�ci wynikowej");
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
     * G�owna r�nica mi�dzy thenReturn(), a then() polega na tym kiedy nast�puje ewaluacja wyniku.
     * W pierwszym przypadku jest to w momencie deklaracji, natomiast w drugim wywo�anie metody nast�pi
     * dopiero wtedy kiedy b�dzie ona potrzebna.
     */


    /**
     * Przydatn� funkcjonalno�ci� jest mo�liwo�� nakazania mockowi rzucenie wyj�tku. S�u�y do
     * tego metoda thenThrow(Throwable... t)  . Poni�szy test nie przejdzie z powodu wyj�tku,
     * kt�ry zostanie rzucony przy wywo�aniu user.getName()
     */
    @Test
    public void shouldThrowExceptionOnGetter() {
        User user = Mockito.mock(User.class);
        Mockito.when(user.getName()).thenThrow(new NullPointerException());

        assertThat(user.getName());
    }

    /**
     * W przypadku metod, kt�re zwracaj� void powy�sza metoda nie zadzia�a.
     * Wynika to z tego jak w Javie obs�ugiwany jest typ void. W takim przypadku nale�y u�y� jej odpowiednika Mockito.doThrow()
     */

    @Test
    public void shouldHandleVoidMethod() {
        User user = Mockito.mock(User.class);

        Mockito.doThrow(new IllegalStateException()).when(user).setName("Kasia");

        user.setName("Basia"); // <-- powiedzie si� test
        user.setName("Kasia"); // <-- dopiero tu zostanie wyrzucony wyj�tek
    }

    /**
     * Jednak gdyby�my chcieli, �eby wyj�tek by� rzucony dla ka�dego argumentu nale�y u�y� ArgumentMatchera:
     */
    @Test
    public void shouldHandleVoidMethod2() {
        User user = Mockito.mock(User.class);

        Mockito.doThrow(new IllegalStateException()).when(user).setName(ArgumentMatchers.anyString());

        user.setName("Basia"); // <-- zostanie wyrzucony wyj�tek
        user.setName("Kasia"); // <-- zostanie wyrzucony wyj�tek
    }


}