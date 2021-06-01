package org.perscholas.sms.entity;

public enum UserType {

    STUDENT("Student"),
    INSTRUCTOR("Instructor"),
    ADMIN("Admin");

    private String capName;

    private UserType(String capName) {
        this.capName = capName;
    }

    public String getCapName() {
        return capName;
    }

}
