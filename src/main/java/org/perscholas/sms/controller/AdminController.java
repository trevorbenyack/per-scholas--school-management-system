package org.perscholas.sms.controller;

import lombok.AllArgsConstructor;
import lombok.extern.java.Log;
import org.perscholas.sms.entity.Student;
import org.perscholas.sms.entity.User;
import org.perscholas.sms.service.AdminService;
import org.perscholas.sms.service.IdentityService;
import org.perscholas.sms.service.StudentService;
import org.perscholas.sms.service.UserService;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@Controller
@RequestMapping("/admin")
@AllArgsConstructor
@Log
public class AdminController {

    StudentService studentService;
    AdminService adminService;
    UserService userService;
    IdentityService identityService;

    @GetMapping("/viewAllStudents")
    public String viewAllStudents(Model model) {
        List<Student> students = studentService.getAllStudents();
        model.addAttribute("students", students);
        model.addAttribute("user", identityService.getCurrentUser());
        return "viewAllStudents";
    }

    @GetMapping("/registerStudentToCourse")
    public String registerStudentToCourse(Model model) {
        model.addAttribute("user", identityService.getCurrentUser());
        return "registerStudentToCourse";
    }

    @GetMapping("/createCourse")
    public String createCourse(Model model) {
        model.addAttribute("user", identityService.getCurrentUser());
        return "createCourse";
    }

    @GetMapping("/addUser")
    public String addUser(Model model) {
        model.addAttribute("user", identityService.getCurrentUser());
        return "addUser";
    }

    @PostMapping("userSearchResults")
    public String userSearchResultsPost(@RequestParam String userSearch, Model model) {
        model.addAttribute("userSearch", userSearch);
        model.addAttribute("user", identityService.getCurrentUser());
        return "userSearchResults";
    }

}
