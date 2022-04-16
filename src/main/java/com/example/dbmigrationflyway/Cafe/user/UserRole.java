package com.example.dbmigrationflyway.Cafe.user;

import com.google.common.collect.Sets;

import java.util.Set;

import static com.example.dbmigrationflyway.Cafe.user.UserPermissions.*;

public enum UserRole {
    USER(Sets.newHashSet()),
    ADMIN(Sets.newHashSet(USER_READ, USER_WRITE));

    private final Set<UserPermissions> permissions;

    UserRole(Set<UserPermissions> permissions) {
        this.permissions = permissions;
    }

    public Set<UserPermissions> getPermissions() {
        return permissions;
    }
}
