package org.perscholas.sms.entity;

import lombok.*;
import lombok.experimental.FieldDefaults;

import javax.persistence.*;
import java.io.Serializable;


@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
@FieldDefaults(level = AccessLevel.PRIVATE)
@ToString
@Entity
@Table(name = "user")
@Inheritance(strategy = InheritanceType.JOINED)
public class User implements Serializable {

    static final long serialVersionUID = 6381462249347345007L;

    @Id @GeneratedValue(strategy = GenerationType.IDENTITY)
    Long Id;

    @Column(nullable = false)
    String password;

    @Column(nullable = false, unique = true)
    String email;

    @Column(nullable = false)
    String firstName;

    @Column(nullable = false)
    String lastName;

    @Column(nullable = false)
    String streetAddress;

    @Column(nullable = false)
    String city;

    @Column(nullable = false)
    String country;

    @Column(nullable = false)
    String postalCode;

    String phoneNumber;

    String imageUrl;

    // Using userType enum to avoid having to do extra db queries
    // inorder to conditionally show views and view elements
    UserType userType;


}
