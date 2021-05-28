package org.perscholas.sms.controller;

import lombok.AllArgsConstructor;
import lombok.extern.java.Log;
import org.perscholas.sms.dao.StudentRepository;
import org.perscholas.sms.entity.Course;
import org.perscholas.sms.entity.Instructor;
import org.perscholas.sms.entity.Student;
import org.perscholas.sms.entity.User;
import org.perscholas.sms.service.StudentService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Optional;
import java.util.Set;

// tells controller to apply @ModelAttribute function to all request mappings
@ControllerAdvice // Delete when login functionality is added

@SessionAttributes({"student", "courses"})  //creates a student object that can be called
@Controller
@RequestMapping("/user/student")
@AllArgsConstructor
@Log
public class StudentController {

    StudentService studentService;

    // Sets student to 1
    // This will be deleted once we add login functionality
    @ModelAttribute("student")
    public Student initializeStudent() {

        System.out.println("inside initialize student");

        return studentService.getStudentById(1L);
    }

    @ModelAttribute("courses")
    public List<Course> initializeCourses() {
        Student student = studentService.getStudentById(1L);
        List<Course> courses = student.getCourses();

        System.out.println("inside initialize student");
        courses.forEach(System.out::println);
        System.out.println("Instructors:");
        for(Course course : courses) {
            List<Instructor> instructors = course.getInstructors();
            System.out.println("Course: " + course.getCourseName());
            instructors.forEach(instructor -> {
                System.out.println(instructor.getFirstName());
            });
        }



        return courses;
    }

    @GetMapping("/courses")
    public String courses() {
        List<Course> courses = studentService.getStudentById(1L).getCourses();
        courses.forEach(System.out::println);
        return "courses";
    }

}
