package org.perscholas.sms.controller;

import lombok.AllArgsConstructor;
import lombok.extern.java.Log;
import org.perscholas.sms.dao.StudentRepository;
import org.perscholas.sms.entity.Course;
import org.perscholas.sms.entity.Instructor;
import org.perscholas.sms.entity.Student;
import org.perscholas.sms.entity.User;
import org.perscholas.sms.service.CourseService;
import org.perscholas.sms.service.IdentityService;
import org.perscholas.sms.service.StudentService;
import org.perscholas.sms.service.UserService;
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
@Controller
@RequestMapping("/student")
@AllArgsConstructor
@Log
public class StudentController {

    UserService userService;
    StudentService studentService;
    IdentityService identityService;
    CourseService courseService;


    //github.com/trevorbenyack/per-scholas--school-management-system // Sets student to 1
    // This will be deleted once we add login functionality

//    @ModelAttribute("courses")
//    public List<Course> initializeCourses() {
//        Student student = studentService.getStudentById(1L);
//        List<Course> courses = student.getCourses();
//
//        System.out.println("inside initialize student");
//        System.out.println("Instructors:");
//        for(Course course : courses) {
//            List<Instructor> instructors = course.getInstructors();
//            System.out.println("Course: " + course.getCourseName());
//            instructors.forEach(instructor -> {
//                System.out.println(instructor.getFirstName());
//            });
//        }
//
//
//
//        return courses;
//    }

    @GetMapping("/profile")
    public String showProfile(Model model) {

        User user = studentService.getCurrentStudent();

        model.addAttribute("user", user);
        return "profile";
    }

    @PostMapping("/updateProfile")
    public String updateProfile(@ModelAttribute("user") User user) {
        userService.updateUser(user);
        return "redirect:/student/profile";
    }

    @GetMapping("/courses")
    public String courses(Model model) {

        Student student = studentService.getCurrentStudent();

        List<Course> courses = student.getCourses();

        model.addAttribute("courses", courses);
        return "courses";
    }

    @GetMapping("/register")
    public String register(Model model) {

        List<Course> unregCourses = studentService.getUnregisteredCourses();
        model.addAttribute("unregCourses", unregCourses);

        return "register";
    }

    @PostMapping("/registerStudentToCourse")
    @ResponseBody
    public String registerStudentToCourse(@RequestParam String Id) {

        Student student = studentService.getCurrentStudent();
        Course course = courseService.getCourseById(Long.parseLong(Id));
        studentService.registerStudentToCourse(student, course);

        return "success";
    }



}
