package com.example.userservice.config.interceptor;

import feign.RequestInterceptor;
import feign.RequestTemplate;
import lombok.RequiredArgsConstructor;
import org.springframework.context.annotation.Configuration;
import org.springframework.security.oauth2.client.OAuth2AuthorizeRequest;
import org.springframework.security.oauth2.client.OAuth2AuthorizedClientManager;
import org.springframework.security.oauth2.client.OAuth2AuthorizedClientService;


@Configuration
@RequiredArgsConstructor
public class FeignClientInterceptor implements RequestInterceptor {
    private static final String AUTHORIZATION_HEADER = "Authorization";
    private static final String BEARER_TOKEN = "Bearer";
    private final OAuth2AuthorizedClientManager clientManager;

    @Override
    public void apply(RequestTemplate requestTemplate) {
        String token = clientManager.authorize(
                OAuth2AuthorizeRequest.withClientRegistrationId("my-internal-client")
                        .principal("internal")
                        .build()
                )
                .getAccessToken()
                .getTokenValue();
        requestTemplate.header(AUTHORIZATION_HEADER, BEARER_TOKEN + " " + token);
    }
}
