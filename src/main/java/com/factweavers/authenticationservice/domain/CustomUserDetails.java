package com.factweavers.authenticationservice.domain;

import lombok.Data;
import org.springframework.security.core.GrantedAuthority;
import org.springframework.security.core.userdetails.UserDetails;

import java.util.Collection;
import java.util.UUID;


@Data
public class CustomUserDetails implements UserDetails {
    private UUID userId;
    private String username;
    private String password;

    private String status;
    private Collection<? extends GrantedAuthority> authorities;

    public CustomUserDetails(UUID userId, String username, String password, Collection<? extends GrantedAuthority> authorities, String status) {
        this.userId = userId;
        this.username = username;
        this.password = password;
        this.authorities = authorities;
        this.status = status;
    }

    public UUID getUserId() {
        return userId;
    }

    @Override
    public Collection<? extends GrantedAuthority> getAuthorities() {
        return authorities;
    }

    @Override
    public String getPassword() {
        return password;
    }

    @Override
    public String getUsername() {
        return username;
    }

    @Override
    public boolean isAccountNonExpired() {
        return true;
    }

    @Override
    public boolean isAccountNonLocked() {
        return true;
    }

    @Override
    public boolean isCredentialsNonExpired() {
        return true;
    }

    @Override
    public boolean isEnabled() {
        return true;
    }


    // Implement other methods as needed

}

