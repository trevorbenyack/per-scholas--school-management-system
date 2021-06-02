package org.perscholas.sms.controller;

import org.perscholas.sms.entity.Course;
import org.perscholas.sms.util.InitializerUtil;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;

import java.util.List;

@Controller
public class HomeController {

    @GetMapping("/")
    public String index() {
        return "login";
    }

    @GetMapping("/login")
    public String login() {
        return "login";
    }

    @GetMapping("/generalInfo")
    public String generalInfo() {
        return "generalInformation";
    }

    //403 page
    @GetMapping("/403")
    public String access(){
        return "403";
    }



}
