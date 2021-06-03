package org.perscholas.sms.entity;

import lombok.AccessLevel;
import lombok.Getter;
import lombok.Setter;
import lombok.ToString;
import lombok.experimental.FieldDefaults;

import javax.persistence.Entity;
import javax.persistence.PrimaryKeyJoinColumn;

@Getter
@Setter
@FieldDefaults(level = AccessLevel.PRIVATE)
@ToString
@Entity
@PrimaryKeyJoinColumn(name = "admin_id")
public class Admin extends User {

    public Admin() {
        super.setUserType(UserType.ADMIN);
    }

    static final long serialVersionUID = 6381462249344345007L;

}
