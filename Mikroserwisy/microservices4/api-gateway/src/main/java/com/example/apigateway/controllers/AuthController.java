package com.example.apigateway.controllers;

import com.example.apigateway.model.AuthResponse;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.http.ResponseEntity;
import org.springframework.security.core.GrantedAuthority;
import org.springframework.security.core.annotation.AuthenticationPrincipal;
import org.springframework.security.oauth2.client.OAuth2AuthorizedClient;
import org.springframework.security.oauth2.client.annotation.RegisteredOAuth2AuthorizedClient;
import org.springframework.security.oauth2.core.oidc.user.OidcUser;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
@RequestMapping("/auth")
@RequiredArgsConstructor
@Slf4j
public class AuthController {

    @GetMapping("/login")
    public ResponseEntity<AuthResponse> login(
            @RegisteredOAuth2AuthorizedClient("okta") OAuth2AuthorizedClient client,
            @AuthenticationPrincipal OidcUser user,
            Model model
            ) {
        log.info("user email id : {} ", user.getEmail());
        AuthResponse authResponse = new AuthResponse();
        authResponse.setUserId(user.getEmail());
        authResponse.setAccessToken(client.getAccessToken().getTokenValue());
        authResponse.setRefreshToken(client.getRefreshToken().getTokenValue());
        authResponse.setExpireAt(client.getAccessToken().getExpiresAt().getEpochSecond());
        List<String> authorities = user.getAuthorities().stream().map(GrantedAuthority::getAuthority).toList();
        authResponse.setAuthorities(authorities);

        return ResponseEntity.ok(authResponse);
    }
}
