package org.perscholas.sms.controller;

import lombok.AllArgsConstructor;
import lombok.extern.java.Log;
import org.perscholas.sms.entity.Course;
import org.perscholas.sms.entity.User;
import org.perscholas.sms.service.IdentityService;
import org.perscholas.sms.service.InstructorService;
import org.perscholas.sms.service.StudentService;
import org.perscholas.sms.service.UserService;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;

import java.util.List;


// tells controller to apply @ModelAttribute function to all request mappings
@ControllerAdvice // Delete when login functionality is added
@SessionAttributes({"user"/*, "userEmail"*/})  // adds
@Controller
@RequestMapping("/user")
@AllArgsConstructor
@Log
public class UserController {


    UserService userService;
    IdentityService identityService;

    // Sets user to 1
    // This will be deleted once we add login functionality
    @ModelAttribute("user")
    public User userObject() {

        return identityService.getCurrentUser();
    }


//    // takes in userEmail from form,
//    @GetMapping("/showUserDetails")
//    public String showUserDetailsByEmail(@SessionAttribute("userEmail") String userEmail, Model model){
//        User user = userService.getUserByEmail(userEmail);  // uses sessions to take email from redirect
//        model.addAttribute("user", user);
//        log.info("user email through session is " + userEmail);
//        System.out.println("\n\n\n" + user + "\n\n\n");
//        return "showUser";
//    }

//    @GetMapping("/{userId}")
//    public String showUserDetailsById(@PathVariable String userId, Model model){
//        User user = userService.getUserbyId(Long.parseLong(userId));
//        model.addAttribute("user", user);
//        log.info("user email through session is " + userId);
//        return "showUser";
//    }

//    @GetMapping("/getUserByEmailForm")
//    public String getUserByEmailForm(){
//        return "getUserByEmailForm";
//    }

//    @PostMapping("/userByEmailForm")
//    public String userByEmail(@RequestParam String user_email, Model model){
//        model.addAttribute("userObject", user_email);
//        log.info("user email is " + user_email);
//        return "redirect:/user/showUserPage" ;
//    }




}
