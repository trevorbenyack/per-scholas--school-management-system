package org.perscholas.sms.service;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.Setter;
import org.perscholas.sms.dao.CourseRepository;
import org.perscholas.sms.entity.Course;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
@AllArgsConstructor
public class CourseService {

    CourseRepository courseRepository;

    public List<Course> getAllCourses() {
        return courseRepository.findAll();
    }

    public Course getCourseById(Long courseId) {
        return courseRepository.getById(courseId);
    }

}
