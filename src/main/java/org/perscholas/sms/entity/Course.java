package org.perscholas.sms.entity;

import lombok.*;
import lombok.experimental.FieldDefaults;

import javax.persistence.*;
import java.io.Serializable;
import java.util.Date;
import java.util.List;

@Entity
@Table(name="course")
@Getter
@Setter
@ToString
@NoArgsConstructor
@AllArgsConstructor
@FieldDefaults(level = AccessLevel.PRIVATE)
public class Course implements Serializable {

    static final long serialVersionUID = 6382462249344345007L;

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name= "course_id")
    Long courseId;

    @Column (name = "course_name")
    String courseName;

    String courseCode;
    Date startDate;
    Date endDate;

    @ToString.Exclude
    @ManyToMany
    @JoinTable (
        name="student_course",
        inverseJoinColumns=@JoinColumn(name = "student_id"),
        joinColumns=@JoinColumn(name = "course_id")
    )
    List<Student> students;

    @ToString.Exclude
    @ManyToMany
    @JoinTable
    (
        name= "instructor_course",
        joinColumns=@JoinColumn(name = "course_id"),
        inverseJoinColumns=@JoinColumn( name = "instructor_id")
    )
    List<Instructor> instructors;

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;

        Course course = (Course) o;

        return courseId.equals(course.courseId);
    }

    @Override
    public int hashCode() {
        return courseId.hashCode();
    }
}
