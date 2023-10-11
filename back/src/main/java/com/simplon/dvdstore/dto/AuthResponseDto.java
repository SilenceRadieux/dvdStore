package com.simplon.dvdstore.dto;

import lombok.Getter;
import org.springframework.security.core.userdetails.UserDetails;

/**
 * The type Auth response dto.
 */
@Getter
public class AuthResponseDto {

    private UserDetails user;

    private String token;

    /**
     * Instantiates a new Auth response dto.
     *
     * @param user  the user
     * @param token the token
     */
    public AuthResponseDto(UserDetails user, String token) {
        this.user = user;
        this.token = token;
    }

    /**
     * Sets user.
     *
     * @param user the user
     */
    public void setUser(UserDetails user) {
        this.user = user;
    }

    /**
     * Sets token.
     *
     * @param token the token
     */
    public void setToken(String token) {
        this.token = token;
    }

}
