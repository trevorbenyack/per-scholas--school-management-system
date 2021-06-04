package org.perscholas.sms.entity;

import lombok.*;
import lombok.experimental.FieldDefaults;
import org.springframework.stereotype.Component;

import javax.persistence.*;
import javax.validation.constraints.NotBlank;
import java.io.Serializable;

// This entity holds which user type(s) each user is

@Entity
@Data
@NoArgsConstructor
@RequiredArgsConstructor
@AllArgsConstructor
@FieldDefaults(level = AccessLevel.PRIVATE)
// @Component // Commented out b/c I don't think I need this
public class UserAuthType implements Serializable {
    private static final long serialVersionUID = 1L;

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    Long authTypeId;

    @ManyToOne
    @NonNull @NotBlank
    User user;

    @OneToOne
    @NonNull @NotBlank
    UserType userType;

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;

        UserAuthType that = (UserAuthType) o;

        return authTypeId.equals(that.authTypeId);
    }

    @Override
    public int hashCode() {
        return authTypeId.hashCode();
    }
}
