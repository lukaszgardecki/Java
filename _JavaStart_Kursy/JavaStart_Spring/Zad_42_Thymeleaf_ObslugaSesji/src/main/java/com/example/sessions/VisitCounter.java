package com.example.sessions;

import org.springframework.context.annotation.Scope;
import org.springframework.context.annotation.ScopedProxyMode;
import org.springframework.stereotype.Service;
import org.springframework.web.context.WebApplicationContext;


// żeby wskazać że powinien to być komponent sesyjny, a nie singleton (jak to jest domyślnie) i żeby w kontenerze
// wstrzykiwania zależności nie istniał tylko jeden obiekt tego typu ale tyle obiektów ile sesji będzie istaniało
// po stronie serwera, to musimy dodać adnotację @Scope
// W adnotacji @Scope ustawiamy scopeName na "session" LUB ustawiamy stałą "WebApplicationContext.SCOPE_SESSION"

// Ze względu, że nasza klasa nie implementuje żadnego interfejsu to nie może być tutaj wykorzystany mechanizm
// dynamicznych proxy z Javy tylko musi być wykorzystana biblioteka CG Lib, więc dodatkowo należy ustawić
// atrybut proxyMode na "ScopedProxyMode.TARGET_CLASS"

@Service
@Scope(scopeName = WebApplicationContext.SCOPE_SESSION, proxyMode = ScopedProxyMode.TARGET_CLASS)
public class VisitCounter {
    private int counter;

    public int getCounter() {
        return counter;
    }

    void increment() {
        counter++;
    }
}
