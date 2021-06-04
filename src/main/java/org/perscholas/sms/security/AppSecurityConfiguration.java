package org.perscholas.sms.security;

import lombok.AllArgsConstructor;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Configuration;
import org.springframework.security.authentication.dao.DaoAuthenticationProvider;
import org.springframework.security.config.annotation.authentication.builders.AuthenticationManagerBuilder;
import org.springframework.security.config.annotation.method.configuration.EnableGlobalMethodSecurity;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.annotation.web.builders.WebSecurity;
import org.springframework.security.config.annotation.web.configuration.EnableWebSecurity;
import org.springframework.security.config.annotation.web.configuration.WebSecurityConfigurerAdapter;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.security.web.util.matcher.AntPathRequestMatcher;

/*

        3.
 */

@Configuration
@EnableWebSecurity
@EnableGlobalMethodSecurity(prePostEnabled = true)
@AllArgsConstructor
public class AppSecurityConfiguration extends WebSecurityConfigurerAdapter {

    //3

    // added final to make intellij happy
    private final AppUserDetailsService appUserDetailsService;

    public DaoAuthenticationProvider authenticationProvider(){
        DaoAuthenticationProvider provider = new DaoAuthenticationProvider();
        provider.setUserDetailsService(appUserDetailsService);
        provider.setPasswordEncoder(new BCryptPasswordEncoder(4));
        return provider;
    }

    //4
    @Override
    protected void configure(AuthenticationManagerBuilder auth) throws Exception {
        auth.authenticationProvider(authenticationProvider());
    }

    // 1 -- configure which routes to require authorization
    @Override
    protected void configure(HttpSecurity http) throws Exception {
        http
                .csrf().disable()
                .authorizeRequests()
                .antMatchers("/admin/**").hasAuthority("ROLE_ADMIN")
                .antMatchers("/student/**").hasAnyAuthority("ROLE_STUDENT")
                .antMatchers("/instructor/**").hasAnyAuthority("ROLE_INSTRUCTOR")
                .antMatchers("/**").hasAnyAuthority("ROLE_ADMIN", "ROLE_STUDENT", "ROLE_INSTRUCTOR")
                .anyRequest().authenticated()
                .and()
                .formLogin().loginPage("/login").usernameParameter("username").passwordParameter("password").loginProcessingUrl("/login/authenticate").defaultSuccessUrl("/generalInfo").failureUrl("/login?error=true").permitAll()
                .and()
                .logout().invalidateHttpSession(true).clearAuthentication(true).logoutRequestMatcher(new AntPathRequestMatcher("/logout")).logoutSuccessUrl("/").permitAll().and().exceptionHandling().accessDeniedPage("/403");
    }

    // 2 -- Choose which routes to not require authorization
    @Override
    public void configure(final WebSecurity web) throws Exception {
        web.ignoring().antMatchers("/resources/**", "/static/**", "/css/**", "/js/**", "/imgs/**");
    }
//    @Bean
//    @Override
//    public UserDetailsService userDetailsService() {
//        List<UserDetails> users = new ArrayList<>();
//        users.add(AuthType.withDefaultPasswordEncoder().username("admin").password("password").roles("USER", "ADMIN").build());
//        users.add(AuthType.withDefaultPasswordEncoder().username("user").password("password").roles("USER").build());
//        return new InMemoryUserDetailsManager(users);
//    }
}
