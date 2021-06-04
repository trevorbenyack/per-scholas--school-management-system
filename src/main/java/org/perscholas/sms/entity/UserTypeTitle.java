package org.perscholas.sms.entity;

public enum UserTypeTitle {

    STUDENT("ROLE_STUDENT"),
    INSTRUCTOR("ROLE_INSTRUCTOR"),
    ADMIN("ROLE_ADMIN");

    private final String role;

    private UserTypeTitle(String role) {
        this.role = role;
    }

    public String getRole() {
        return role;
    }

}
