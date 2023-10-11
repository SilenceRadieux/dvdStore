package com.simplon.dvdstore.services;

import org.springframework.security.core.userdetails.UserDetails;

/**
 * The interface Jwt user service.
 */
public interface JwtUserService extends UserService {

    /**
     * Generate jwt user string.
     *
     * @param user the user
     * @return the string
     */
    String generateJwtUser(UserDetails user);

    /**
     * Gets user from jwt.
     *
     * @param jwt the jwt
     * @return the user from jwt
     */
    UserDetails getUserFromJwt(String jwt);

}
