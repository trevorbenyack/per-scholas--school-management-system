package org.perscholas.sms.controller;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;

@Controller
@RequestMapping("/admin")
public class adminController {

    @GetMapping("/viewAllStudents")
    public String viewAllStudents() {
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
}
