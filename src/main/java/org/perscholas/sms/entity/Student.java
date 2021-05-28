package org.perscholas.sms.entity;

import lombok.*;
import lombok.experimental.FieldDefaults;
import javax.persistence.*;
import java.io.Serializable;
import java.util.Date;
import java.util.List;

@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
@FieldDefaults(level = AccessLevel.PRIVATE)
@ToString
@Entity
@PrimaryKeyJoinColumn(name = "student_id")
public class Student extends User implements Serializable {

    static final long serialVersionUID = 6381462249344345007L;

    Integer dormId;
    Integer roomNum;
    Date enrollmentDate;
    Date graduationDate;

    @ToString.Exclude
    @ManyToMany(fetch = FetchType.EAGER)
    @JoinTable
    (
        name= "student_course",
        joinColumns=@JoinColumn(name = "student_id"),
        inverseJoinColumns=@JoinColumn( name = "course_id")
    )
    List<Course> courses;




}
