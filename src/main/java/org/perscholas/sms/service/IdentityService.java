package org.perscholas.sms.service;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.Setter;
import org.perscholas.sms.entity.User;
import org.springframework.stereotype.Service;
import org.springframework.ui.Model;

@Service
@Getter
@Setter
@AllArgsConstructor
public class IdentityService {

    // STUBBING
    final String userEmail = "hluckham0@google.ru";
    UserService userService;

    public User getCurrentUser() {
        return userService.getUserByEmail(userEmail);
    }

}
