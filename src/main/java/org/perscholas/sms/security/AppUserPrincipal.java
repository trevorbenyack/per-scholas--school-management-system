package org.perscholas.sms.security;

import org.perscholas.sms.entity.AuthGroup;
import org.perscholas.sms.entity.User;
import org.springframework.security.core.GrantedAuthority;
import org.springframework.security.core.authority.SimpleGrantedAuthority;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.stereotype.Component;

import java.util.*;

@Component
public class AppUserPrincipal implements UserDetails {

    //fields
    private User user;
    private List<AuthGroup> authGroups;

    public AppUserPrincipal(User user, List<AuthGroup> authGroups) {
        this.user = user;
        this.authGroups = authGroups;
    }

    @Override
    public Collection<? extends GrantedAuthority> getAuthorities() {

        if(null == authGroups){
            return Collections.emptySet();
        }

        //init
        Set<SimpleGrantedAuthority> grantedAuthorities = new HashSet<>();

        authGroups.forEach(authGroup -> {
            grantedAuthorities.add(new SimpleGrantedAuthority(authGroup.getAAuthGroup()));
        });

        return grantedAuthorities;
        // return Collections.singleton(new SimpleGrantedAuthority("USER"));
    }


    @Override
    public String getPassword() {
        return this.user.getPassword();
    }

    @Override
    public String getUsername() {
        return this.user.getEmail();
    }

    @Override
    public boolean isAccountNonExpired() {
        return true;
    }

    @Override
    public boolean isAccountNonLocked() {
        return true;
    }

    @Override
    public boolean isCredentialsNonExpired() {
        return true;
    }

    @Override
    public boolean isEnabled() {
        return true;
    }
}
