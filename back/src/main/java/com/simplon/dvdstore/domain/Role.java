package com.simplon.dvdstore.domain;

import jakarta.persistence.*;
import org.springframework.security.core.GrantedAuthority;

/**
 * The type Role.
 */
@Entity
public class Role implements GrantedAuthority {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int id;
    @Column(nullable = false)
    private String name;

    @Override
    public String getAuthority() {
        return name;
    }

}