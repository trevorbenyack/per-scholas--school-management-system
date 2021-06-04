package org.perscholas.sms.entity;

import lombok.*;
import lombok.experimental.FieldDefaults;

import javax.persistence.*;
import java.io.Serializable;

@Getter
@Setter
@FieldDefaults(level = AccessLevel.PRIVATE)
@ToString
@Entity
@NoArgsConstructor
public class Admin implements Serializable {

    static final long serialVersionUID = 6381462249344345007L;

    @Id @GeneratedValue(strategy = GenerationType.IDENTITY)
    Long adminId;

    @OneToOne
    UserAuthType userAuthType;

}
