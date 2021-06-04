package org.perscholas.sms.entity;

import lombok.*;
import lombok.experimental.FieldDefaults;

import javax.persistence.*;
import java.io.Serializable;
import java.util.List;

@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
@FieldDefaults(level = AccessLevel.PRIVATE)
@ToString
@Entity
public class Instructor implements Serializable {

    static final long serialVersionUID = 6382462249344345007L;

    @Id @GeneratedValue(strategy = GenerationType.IDENTITY)
    Long instructorId;
    String department;
    String title;
    String officeId;

    @OneToOne
    UserAuthType userAuthType;

    @ToString.Exclude
    @ManyToMany
    @JoinTable
    (
        name= "instructor_course",
        joinColumns=@JoinColumn(name = "instructor_id"),
        inverseJoinColumns=@JoinColumn( name = "course_id")
    )
    List<Course> courses;

}