package com.factweavers.authenticationservice.controller;

import com.factweavers.authenticationservice.config.security.ApiResponse;
import com.factweavers.authenticationservice.domain.User;
import com.factweavers.authenticationservice.repository.UserRepository;
import com.factweavers.authenticationservice.service.UserService;
import com.fasterxml.jackson.databind.JsonNode;
import com.fasterxml.jackson.databind.ObjectMapper;
import com.fasterxml.jackson.datatype.jsr310.JavaTimeModule;
import lombok.AllArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.apache.http.client.utils.URIBuilder;
import org.jetbrains.annotations.NotNull;
import org.springframework.http.*;
import org.springframework.security.access.prepost.PreAuthorize;
import org.springframework.security.authentication.UsernamePasswordAuthenticationToken;
import org.springframework.security.core.GrantedAuthority;
import org.springframework.security.core.authority.SimpleGrantedAuthority;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.oauth2.common.OAuth2AccessToken;
import org.springframework.security.oauth2.provider.OAuth2Authentication;
import org.springframework.security.oauth2.provider.OAuth2Request;
import org.springframework.security.oauth2.provider.endpoint.TokenEndpoint;
import org.springframework.security.oauth2.provider.token.DefaultTokenServices;
import org.springframework.util.LinkedMultiValueMap;
import org.springframework.util.MultiValueMap;
import org.springframework.util.StringUtils;
import org.springframework.web.HttpRequestMethodNotSupportedException;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.client.RestTemplate;
import org.springframework.web.servlet.support.ServletUriComponentsBuilder;

import javax.inject.Inject;
import java.io.IOException;
import java.net.MalformedURLException;
import java.net.URISyntaxException;
import java.security.Principal;
import java.util.*;

@RestController
@Slf4j
@AllArgsConstructor
public class UserController {

//    @Inject
//    private DefaultTokenServices defaultTokenServices;

//    CustomTokenServices tokenServices;
//
//    DefaultOAuth2RequestFactory defaultOAuth2RequestFactory;

//    AuthenticationManager authenticationManager;

    DefaultTokenServices tokenService;

    UserService userService;

    @Inject
    private UserRepository userRepository;
    //
    @Inject
    private TokenEndpoint tokenEndpoint;

    @RequestMapping("/token")
    public OAuth2AccessToken home() throws IOException, HttpRequestMethodNotSupportedException {
        ResponseEntity response;
//        RestTemplate restTemplate = new RestTemplate();
//
//        UserDetails user = userService.loadUserByUsername("sanju.sadasivan@dbizsolution.com");
//        HashMap<String, String> authorizationParameters = new HashMap<String, String>();
//        authorizationParameters.put("scope", "openid");
//        authorizationParameters.put("username", user.getUsername());
//        authorizationParameters.put("client_id", "myClient");
//        authorizationParameters.put("grant_type", "password");
//        Collection<? extends GrantedAuthority>  authorities =  user.getAuthorities();
//
//
//        Set<String> responseType = new HashSet<String>();
//        responseType.add("password");
//
//        Set<String> scopes = new HashSet<String>();
//        scopes.add("read");
//        scopes.add("write");
//        scopes.add("openid");
//
//
//        OAuth2Request authorizationRequest = new OAuth2Request(authorizationParameters, "myClient", authorities, true,
//                scopes, null, "", responseType, null);
//
//        org.springframework.security.core.userdetails.User userPrincipal = new org.springframework.security.core.userdetails.User(
//                user.getUsername(), user.getPassword(), authorities);
//        UsernamePasswordAuthenticationToken authenticationToken = new UsernamePasswordAuthenticationToken(userPrincipal,
//                null, authorities);
//
//        OAuth2Authentication authenticationRequest = new OAuth2Authentication(authorizationRequest,
//                authenticationToken);
//        authenticationRequest.setAuthenticated(true);
//        OAuth2AccessToken accessToken = tokenService.createAccessToken(authenticationRequest);
//
//        return accessToken;
////////////////////////////////////////////////






        UserDetails userPrincipal = userService.loadUserByUsername("nidhinalungal@gmail.com");

        OAuth2Authentication authenticationRequest = getoAuth2Authentication(userPrincipal);

        OAuth2AccessToken accessToken = tokenService
                .createAccessToken(authenticationRequest);

        return accessToken;

//         According OAuth documentation we need to send the client id and secret key in the header for authentication
//        HttpHeaders headers = new HttpHeaders();
//        headers.setAccept(Arrays.asList(MediaType.APPLICATION_JSON));
//        headers.setBasicAuth("myClient", "myClientSecret");
//
//        MultiValueMap<String, String> urlParams = new LinkedMultiValueMap<>();
//        urlParams.add("username", "sanju.sadasivan@dbizsolution.com");
////        urlParams.add("password", "Test@123");
//        urlParams.add("grant_type", "client_credentials");
//        urlParams.add("scope", "openid");
//
////        map.add("grant_type", "client_credentials");
////        map.add("client_id", "your-client-id");
////        map.add("client_secret", "your-client-secret");
//
//        HttpEntity<MultiValueMap<String, String>> entity = new HttpEntity<>(urlParams, headers);
//        String oauthCompleteURL = ServletUriComponentsBuilder.fromCurrentContextPath().path("/oauth/token").toUriString();
//
//        String oAuthTokenUri = "";
//        try {
//            oAuthTokenUri = new URIBuilder(oauthCompleteURL).build().toURL().toString();
//        } catch (URISyntaxException e) {
//            log.error("<---URISyntaxException---->" + e.getMessage());
//        } catch (MalformedURLException e) {
//            throw new RuntimeException(e);
//        }
//        System.out.println("OAUTH COMPLETE URL TO DEBUG");
//        System.out.println(oAuthTokenUri);
//        String processedOAuthTokenUri = StringUtils.replace(oAuthTokenUri, "http", "http");
//        log.info("<---oAuthTokenUri--->" + processedOAuthTokenUri);
//        response = restTemplate.exchange(processedOAuthTokenUri, HttpMethod.POST, entity, JsonNode.class);
//
//        OAuthIdpTokenResponseDTO tokenResponseDTO = new OAuthIdpTokenResponseDTO();
//        ObjectMapper objectMapper = new ObjectMapper();
//        objectMapper.registerModule(new JavaTimeModule());
//        ApiResponse apiResponse = new ApiResponse<>();
//
//        if (response.getStatusCode().is2xxSuccessful()) {
//            tokenResponseDTO = objectMapper.readValue(Objects.requireNonNull(response.getBody()).toString(), OAuthIdpTokenResponseDTO.class);
//            apiResponse.setMessage("token generated");
//            apiResponse.setData(tokenResponseDTO);
//
//            return new ResponseEntity(apiResponse, HttpStatus.OK);
//
//        } else {
//            throw new IllegalStateException("Error occurs during token generation");
//        }


//        return "Hello World, with token";
    }

    @NotNull
    private static OAuth2Authentication getoAuth2Authentication(UserDetails userPrincipal) {
        HashMap<String, String> authorizationParameters = new HashMap<String, String>();

        Collection<? extends GrantedAuthority>  authorities =  userPrincipal.getAuthorities();
        Set<String> responseType = new HashSet<String>();
        responseType.add("password");
        Set<String> scopes = new HashSet<String>();
        scopes.add("openid");

        OAuth2Request authorizationRequest = new OAuth2Request(
                authorizationParameters, "myClient",
                authorities, true, scopes, null, "",
                responseType, null);

//        User userPrincipal = new User("user", "", true, true, true, true, authorities);

        UsernamePasswordAuthenticationToken authenticationToken = new UsernamePasswordAuthenticationToken(
                userPrincipal, null, authorities);


        OAuth2Authentication authenticationRequest = new OAuth2Authentication(
                authorizationRequest, authenticationToken);
        authenticationRequest.setAuthenticated(true);
        return authenticationRequest;
    }

//    @PreAuthorize("hasAnyAuthority('3.1.3', '3.2.3', '2.0.0')")
    @RequestMapping("/test")
    public String test() {
        return "test without token";
    }

    @RequestMapping("/user")
    public Principal user(Principal user) {
        return user;
    }

    @RequestMapping("/test/lucene")
    public String lucene() throws Exception {
        return userService.lucene();
    }

}
