package com.example.spring_security_jwt_2.config;

import com.example.spring_security_jwt_2.token.Token;
import com.example.spring_security_jwt_2.token.TokenRepository;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import lombok.RequiredArgsConstructor;
import org.springframework.security.core.Authentication;
import org.springframework.security.web.authentication.logout.LogoutHandler;
import org.springframework.stereotype.Service;

@Service
@RequiredArgsConstructor
public class MyCustomLogoutHandler implements LogoutHandler {
    private final TokenRepository tokenRepository;

    @Override
    public void logout(
            HttpServletRequest request,
            HttpServletResponse response,
            Authentication authentication
    ) {
        // z requesta pobieramy zawartość nagłówka "Authorization":
        String authHeader = request.getHeader("Authorization");

        //zabezpieczenie!
        // jeżeli request nie posiada nagłówka "Authorization" to nie wykonuj metody
        // jeżeli zawartość nagłówka "Authorization" nie zaczyna się od "Bearer " to nie wykonuj metody
        if (authHeader == null || !authHeader.startsWith("Bearer ")) {
            return;
        }

        //pobierz zawartość tokena z nagłówka
        // token: 'Bearer er78adfg7y98afdy...'
        //pobierz sam token (zaczyna się od 7 znaku - liczone od 0)
        String jwt = authHeader.substring(7);

        //znajdź ten tekon w naszej bazie:
        Token storedToken = tokenRepository.findByToken(jwt).orElse(null);

        // jeżeli taki token istnieje ustaw mu pola expired i revoked na TRUE
        // oraz ponownie zapisz ten token w bazie (jest już nieważny)
        if (storedToken != null) {
            storedToken.setExpired(true);
            storedToken.setRevoked(true);
            tokenRepository.save(storedToken);
        }
    }
}
