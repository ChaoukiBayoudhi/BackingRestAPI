package tn.isg.mssi.BackingRestAPI.Configurations;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.security.authentication.AuthenticationManager;
import org.springframework.security.config.annotation.authentication.builders.AuthenticationManagerBuilder;
import org.springframework.security.config.annotation.method.configuration.EnableGlobalMethodSecurity;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.annotation.web.builders.WebSecurity;
import org.springframework.security.config.annotation.web.configuration.EnableWebSecurity;
import org.springframework.security.config.annotation.web.configuration.WebSecurityConfigurerAdapter;
import org.springframework.security.config.http.SessionCreationPolicy;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.security.web.SecurityFilterChain;
import tn.isg.mssi.BackingRestAPI.Security.AuthEntryPointJwt;
import tn.isg.mssi.BackingRestAPI.Security.UserDetailsImpl;


@EnableWebSecurity //tells spring-boot that this is a class that provides configuration for security
@EnableGlobalMethodSecurity(prePostEnabled = true)//to enable the use of @PreAuthorize an @PotAuthorize in Rest Controller
public class WebSecurityConfig{

    //this configuration method replaces the default basic authentication configuration
    @Bean
    public SecurityFilterChain securityFilterChain(HttpSecurity http) throws Exception {
        http.
                authorizeRequests().
                anyRequest().
                authenticated()
                .and()
                .httpBasic();
        return http.build();
    }
    @Bean
    public PasswordEncoder passwordEncoder() {
        return new BCryptPasswordEncoder();
    }

}

