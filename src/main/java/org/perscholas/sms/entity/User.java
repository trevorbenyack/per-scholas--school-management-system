package org.perscholas.sms.entity;

import lombok.*;
import lombok.experimental.FieldDefaults;
import org.springframework.stereotype.Component;

import javax.persistence.*;
import java.io.Serializable;
import java.util.List;
import java.util.Objects;

@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
@FieldDefaults(level = AccessLevel.PRIVATE)
@ToString
@Entity
@Table(name = "user")
@Component
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

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;

        User user = (User) o;

        if (Id != null ? !Id.equals(user.Id) : user.Id != null) return false;
        if (password != null ? !password.equals(user.password) : user.password != null) return false;
        if (email != null ? !email.equals(user.email) : user.email != null) return false;
        if (firstName != null ? !firstName.equals(user.firstName) : user.firstName != null) return false;
        if (lastName != null ? !lastName.equals(user.lastName) : user.lastName != null) return false;
        if (streetAddress != null ? !streetAddress.equals(user.streetAddress) : user.streetAddress != null)
            return false;
        if (city != null ? !city.equals(user.city) : user.city != null) return false;
        if (country != null ? !country.equals(user.country) : user.country != null) return false;
        if (postalCode != null ? !postalCode.equals(user.postalCode) : user.postalCode != null) return false;
        if (phoneNumber != null ? !phoneNumber.equals(user.phoneNumber) : user.phoneNumber != null) return false;
        return imageUrl != null ? imageUrl.equals(user.imageUrl) : user.imageUrl == null;
    }

    @Override
    public int hashCode() {
        int result = Id != null ? Id.hashCode() : 0;
        result = 31 * result + (password != null ? password.hashCode() : 0);
        result = 31 * result + (email != null ? email.hashCode() : 0);
        result = 31 * result + (firstName != null ? firstName.hashCode() : 0);
        result = 31 * result + (lastName != null ? lastName.hashCode() : 0);
        result = 31 * result + (streetAddress != null ? streetAddress.hashCode() : 0);
        result = 31 * result + (city != null ? city.hashCode() : 0);
        result = 31 * result + (country != null ? country.hashCode() : 0);
        result = 31 * result + (postalCode != null ? postalCode.hashCode() : 0);
        result = 31 * result + (phoneNumber != null ? phoneNumber.hashCode() : 0);
        result = 31 * result + (imageUrl != null ? imageUrl.hashCode() : 0);
        return result;
    }
}
