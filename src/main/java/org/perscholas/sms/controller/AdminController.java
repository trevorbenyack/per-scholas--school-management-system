package org.perscholas.sms.controller;

import lombok.AllArgsConstructor;
import lombok.extern.java.Log;
import org.perscholas.sms.entity.Student;
import org.perscholas.sms.entity.User;
import org.perscholas.sms.service.AdminService;
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

    @GetMapping("/viewAllStudents")
    public String viewAllStudents(Model model) {
        List<Student> students = studentService.getAllStudents();
        model.addAttribute("students", students);
        return "viewAllStudents";
    }

    @GetMapping("/registerStudentToCourse")
    public String registerStudentToCourse() {
        return "registerStudentToCourse";
    }

    @GetMapping("/createCourse")
    public String createCourse() {
        return "createCourse";
    }

    @GetMapping("/addUser")
    public String addUser() {
        return "addUser";
    }

    @PostMapping("userSearchResults")
    public String userSearchResultsPost(@RequestParam String userSearch, Model model) {
        model.addAttribute("userSearch", userSearch);
        return "userSearchResults";
    }

    @GetMapping("/dashboard")
    public String dashboard() {
        return "dashboard";
    }

    @GetMapping("/profile")
    public String showProfile(Model model) {

        log.info("admin/profile has been requested");

        User user = adminService.getCurrentAdmin();

        model.addAttribute("user", user);
        return "profile";
    }

    @PostMapping("/updateProfile")
    public String updateProfile(@ModelAttribute("user") User user) {
        userService.updateUser(user);
        return "redirect:/admin/profile";
    }
}
