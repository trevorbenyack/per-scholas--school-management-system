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
@PrimaryKeyJoinColumn(name = "instructor_id")
public class Instructor extends User implements Serializable {

    static final long serialVersionUID = 6382462249344345007L;

    String department;
    String title;
    String officeId;

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