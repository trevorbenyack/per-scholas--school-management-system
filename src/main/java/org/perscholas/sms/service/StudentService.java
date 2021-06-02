package org.perscholas.sms.service;

import lombok.AllArgsConstructor;
import org.perscholas.sms.dao.StudentRepository;
import org.perscholas.sms.entity.Course;
import org.perscholas.sms.entity.Student;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Propagation;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;
import java.util.stream.Collectors;

@Service
@AllArgsConstructor
public class StudentService {

    StudentRepository studentRepository;
    IdentityService identityService;
    CourseService courseService;

    // This annotation was put here to try to solve a LazyInitializationException
    // Didn't help... but gonna leave it for now.
    @Transactional(propagation= Propagation.REQUIRED, readOnly=true, noRollbackFor=Exception.class)
    public Student getStudentById(Long studentId) {

        return studentRepository.getById(studentId);

    }

    public List<Student> getAllStudents(){
        return studentRepository.findAll();
    }

    public boolean studentExistsById(Long studentId) {
        return studentRepository.existsById(studentId);
    }

    public Student getCurrentStudent() {

        if (studentExistsById(identityService.getCurrentUser().getId())) {
            return getStudentById(identityService.getCurrentUser().getId());
        }
        return null;
    }

    public List<Course> getUnregisteredCourses() {

        List<Course> registeredCourses = getCurrentStudent().getCourses();
        List<Course> allCourses = courseService.getAllCourses();
        return allCourses.stream()
                .filter(c -> !registeredCourses.contains(c))
                .collect(Collectors.toList());

    }

    @Transactional
    public void registerStudentToCourse(Student student, Course course) {
        List<Course> registeredCourses = student.getCourses();

        if (!registeredCourses.contains(course)) {
            registeredCourses.add(course);
        }

    }
}
