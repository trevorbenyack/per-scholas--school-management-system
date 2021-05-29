package org.perscholas.sms.controller;

import org.perscholas.sms.util.InitializerUtil;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;

@Controller
public class HomeController {

    @GetMapping("/")
    public String dashboard() {
        return "dashboard";
    }

    @GetMapping("/login")
    public String login() {
        return "login";
    }

    @PostMapping("/login")
    public String processLogin() {

        // If student, return student header
            // return list of classes
            // also return a list view w/ a register button that they can register for a class
        // If instructor, return instructor header
            // return list of classes
        // If admin instructor, return admin header
            // return list of classes
            // return drop down view of classes, return drop down view of instructors

        return null;
    }



}
