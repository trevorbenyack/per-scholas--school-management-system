package org.perscholas.sms.security;


import lombok.AllArgsConstructor;
import org.perscholas.sms.dao.UserAuthTypeRepository;
import org.perscholas.sms.entity.UserAuthType;
import org.perscholas.sms.entity.User;
import org.perscholas.sms.service.UserAuthTypeService;
import org.perscholas.sms.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
@AllArgsConstructor
public class AppUserDetailsService implements UserDetailsService {

    private final UserService userService;
    private final UserAuthTypeService userAuthTypeService;


    // Using userEmail as parameter b/c this is the information the user provides when logging in
    @Override
    public UserDetails loadUserByUsername(String userEmail) throws UsernameNotFoundException {

        User user = userService.getUserByEmail(userEmail);

        if (user == null){
            throw new UsernameNotFoundException("Cannot find Username: " + userEmail);
        }

        List<UserAuthType> userAuthTypes = userAuthTypeService.getUserAuthTypeByUser(user);
        return new AppUserPrincipal(user, userAuthTypes);
    }
}
