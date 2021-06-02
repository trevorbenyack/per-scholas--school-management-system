package org.perscholas.sms.security;


import org.perscholas.sms.entity.AuthGroup;
import org.perscholas.sms.entity.User;
import org.perscholas.sms.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class AppUserDetailsService implements UserDetailsService {

    private final UserService userService;
    private final IAuthGroup authGroup;

    @Autowired
    public AppUserDetailsService(UserService userService, IAuthGroup authGroup) {
        this.userService = userService;
        this.authGroup = authGroup;
    }

    @Override
    public UserDetails loadUserByUsername(String userEmail) throws UsernameNotFoundException {

        User user = userService.getUserByEmail(userEmail);

        if (user == null){
            throw new UsernameNotFoundException("Cannot find Username: " + userEmail);
        }

        List<AuthGroup> authGroups = authGroup.findByaEmail(userEmail);
        return new AppUserPrincipal(user,authGroups);
    }
}
