package com.factweavers.authenticationservice.config;

import org.springframework.security.oauth2.common.OAuth2AccessToken;
import org.springframework.security.oauth2.provider.OAuth2Authentication;
import org.springframework.security.oauth2.provider.token.store.JwtAccessTokenConverter;

import java.util.Map;

public class CustomJwtAccessTokenConverter extends JwtAccessTokenConverter {

    @Override
    public OAuth2AccessToken enhance(OAuth2AccessToken accessToken, OAuth2Authentication authentication) {

        return super.enhance(accessToken, authentication);
    }

//    @Override
//    public OAuth2Authentication extractAuthentication(Map<String, ?> map) {
//        OAuth2Authentication authentication = super.extractAuthentication(map);
//        // Add the subject claim to the authentication
//        authentication.setDetails(map);
//        return authentication;
//    }
}
