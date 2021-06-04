package org.perscholas.sms.controller;

import lombok.AllArgsConstructor;
import org.perscholas.sms.entity.Course;
import org.perscholas.sms.service.IdentityService;
import org.perscholas.sms.service.UserService;
import org.perscholas.sms.util.InitializerUtil;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;

import java.util.List;

@Controller
@AllArgsConstructor
public class HomeController {

    IdentityService identityService;

    @GetMapping("/")
    public String index() {
        return "login";
    }

    @GetMapping("/login")
    public String login() {
        return "login";
    }

    @GetMapping("/generalInfo")
    public String generalInfo(Model model) {

        model.addAttribute("user", identityService.getCurrentUser());

        return "generalInformation";
    }

    //403 page
    @GetMapping("/403")
    public String access(){
        return "403";
    }



}
