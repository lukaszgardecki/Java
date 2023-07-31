package com.example.userservice.config.interceptor;

import lombok.RequiredArgsConstructor;
import org.springframework.http.HttpRequest;
import org.springframework.http.client.ClientHttpRequestExecution;
import org.springframework.http.client.ClientHttpRequestInterceptor;
import org.springframework.http.client.ClientHttpResponse;
import org.springframework.security.oauth2.client.OAuth2AuthorizeRequest;
import org.springframework.security.oauth2.client.OAuth2AuthorizedClientManager;

import java.io.IOException;

@RequiredArgsConstructor
public class RestTemplateInterceptor implements ClientHttpRequestInterceptor {
    private final OAuth2AuthorizedClientManager manager;

    @Override
    public ClientHttpResponse intercept(HttpRequest request, byte[] body, ClientHttpRequestExecution execution) throws IOException {

        String token = manager.authorize(
                        OAuth2AuthorizeRequest.withClientRegistrationId("my-internal-client")
                                .principal("internal")
                                .build()
                )
                .getAccessToken()
                .getTokenValue();
        request.getHeaders().add("Authorization", "Bearer" + " " + token);
        return execution.execute(request, body);
    }
}
