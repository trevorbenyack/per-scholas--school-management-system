package org.perscholas.sms.entity;

import lombok.*;
import lombok.experimental.FieldDefaults;
import javax.persistence.*;
import java.io.Serializable;
import java.util.Date;
import java.util.List;

@Getter
@Setter
@FieldDefaults(level = AccessLevel.PRIVATE)
@ToString
@Entity
@NoArgsConstructor
public class Student implements Serializable {

    static final long serialVersionUID = 6381462249344345007L;

    @Id @GeneratedValue(strategy = GenerationType.IDENTITY)
    Long studentId;

    @OneToOne
    UserAuthType userAuthType;

    Integer dormId;
    Integer roomNum;
    Date enrollmentDate;
    Date graduationDate;

    @ToString.Exclude
    @ManyToMany
    @JoinTable
    (
        name= "student_course",
        joinColumns=@JoinColumn(name = "student_id"),
        inverseJoinColumns=@JoinColumn( name = "course_id")
    )
    List<Course> courses;




}
