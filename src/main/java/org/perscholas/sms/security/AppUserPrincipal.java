package org.perscholas.sms.security;

import org.perscholas.sms.entity.UserAuthType;
import org.perscholas.sms.entity.User;
import org.springframework.security.core.GrantedAuthority;
import org.springframework.security.core.authority.SimpleGrantedAuthority;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.stereotype.Component;

import java.util.*;

// This packages the user object and its granted Authorities into an AppUserPrincipal object
// That is then registered with the provider in AppSecurityConfiguration.
@Component
public class AppUserPrincipal implements UserDetails {

    private final User user;
    private final List<UserAuthType> userAuthTypes;

    public AppUserPrincipal(User user, List<UserAuthType> userAuthTypes) {
        this.user = user;
        this.userAuthTypes = userAuthTypes;
    }

    // Creates a collection of the user's authorities
    @Override
    public Collection<? extends GrantedAuthority> getAuthorities() {

        if(null == userAuthTypes){
            return Collections.emptySet();
        }

        // init
        Set<SimpleGrantedAuthority> grantedAuthorities = new HashSet<>();

        userAuthTypes.forEach(userAuthType -> {
            grantedAuthorities.add(new SimpleGrantedAuthority(userAuthType.getUserType().getUserTypeTitle().getRole()));
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
        return this.user.getId().toString();
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
