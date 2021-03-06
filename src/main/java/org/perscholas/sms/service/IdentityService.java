package org.perscholas.sms.service;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.Setter;
import lombok.extern.java.Log;
import org.perscholas.sms.entity.User;
import org.perscholas.sms.security.AppUserPrincipal;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.annotation.AuthenticationPrincipal;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;
import org.springframework.ui.Model;

import javax.annotation.PostConstruct;

@Service
@Getter
@Setter
@Log
@Transactional
public class IdentityService {

    // STUBBING
    UserService userService;

    public IdentityService(UserService userService) {
        this.userService = userService;
    }

    public User getCurrentUser() {

        Object user = SecurityContextHolder.getContext().getAuthentication().getPrincipal();
        String username;

        if (user instanceof UserDetails) {
            username = ((UserDetails)user).getUsername();
            log.info("inside IdentityService > getCurrentUser() > if: username is " + username);
        } else {
            username = user.toString();
            log.info("inside else");
        }

        return userService.getUserbyId(Long.parseLong(username));
    }


}
