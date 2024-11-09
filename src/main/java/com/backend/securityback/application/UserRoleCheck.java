package com.backend.securityback.application;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import java.util.Set;

public class UserRoleCheck {
    private static final Logger logger = LoggerFactory.getLogger(UserRoleCheck.class);

    public static void main(String[] args) {
        // Example set of user roles
        Set<Role> userRoles = Set.of(
                new Role("USER"),
                new Role("ADMIN"),
                new Role("MODERATOR")
        );

        // Check if any role is "ADMIN" and log all roles
        boolean hasAdminRole = userRoles.stream()
            .anyMatch(role -> {
                // Log each role's name
                logger.debug("User Role VIEW: {}", role.getNom());
                // Check if the role is "ADMIN"
                return "ADMIN".equals(role.getNom());
            });

        // Print if the user has the "ADMIN" role
        if (hasAdminRole) {
            logger.debug("User has ADMIN role");
        } else {
            logger.debug("User does not have ADMIN role");
        }
    }
}

class Role {
    private String nom;

    public Role(String nom) {
        this.nom = nom;
    }

    public String getNom() {
        return nom;
    }
}

