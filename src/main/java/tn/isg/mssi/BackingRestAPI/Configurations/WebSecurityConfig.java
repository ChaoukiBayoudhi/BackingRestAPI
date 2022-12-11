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


//    @Bean
//    public SecurityFilterChain securityFilterChain(HttpSecurity http) throws Exception {
//        http
//                .authorizeRequests(authorizeRequests ->
//                        authorizeRequests
//                                .antMatchers("/auth/**").permitAll()
//                                .anyRequest().authenticated()
//                )
//                .exceptionHandling(exceptionHandling ->
//                        exceptionHandling
//                                .authenticationEntryPoint(new AuthEntryPointJwt())
//                )
//                .sessionManagement(sessionManagement ->
//                        sessionManagement
//                                .sessionCreationPolicy(SessionCreationPolicy.STATELESS)
//                )
//                .csrf(csrf ->
//                        csrf
//                                .disable()
//                )
//                .formLogin(formLogin ->
//                        formLogin
//                                .disable()
//                )
//                .httpBasic(httpBasic ->
//                        httpBasic
//                                .disable()
//                )
//                .logout(logout ->
//                        logout
//                                .disable()
//                );
//        return http.build();
//
//    }
//    @Bean
//    public PasswordEncoder passwordEncoder() {
//        return new BCryptPasswordEncoder();
//    }
//    @Bean
//    public AuthEntryPointJwt authEntryPointJwt() {
//        return new AuthEntryPointJwt();
//    }
//    @Bean
//    public UserDetailsImpl userDetails() {
//        return new UserDetailsImpl();
//        //return new UserDetailsImpl("user", "password");
//        //return new UserDetailsImpl("admin", "password");
//    }
//
//
//    @Bean
//    public SecurityFilterChain filterChain(HttpSecurity http) throws Exception {
//                http.csrf().disable().authorizeRequests().anyRequest().authenticated().and().httpBasic();
//                http.headers().frameOptions().disable();
//                return http.build();
//    }
//
////    @Bean
////    public SessionCreationPolicy sessionCreationPolicy() {
////        return new SessionCreationPolicy();
////        //return new SessionCreationPolicy(true);
////
////
////        //return new SessionCreationPolicy(true, 30, TimeUnit.MINUTES);
////        //return new SessionCreationPolicy(true, 60, TimeUnit.MINUTES);
////    }
//    @Bean
//    public AuthenticationManager authenticationManager() throws Exception {
//        return authenticationManager;
//        //return super.authenticationManager();
//
//    }
//
//    @Override
//    public void configure(AuthenticationManagerBuilder auth) throws Exception {
//        auth.userDetails(userDetails())
//               .passwordEncoder(passwordEncoder())
//               .authorities("ROLE_USER")
//               .and()
//               .withUserDetails(userDetails())
//               .and()
//               .withUserDetails(userDetails())
//
//    }
//    @Override
//    public void configure(HttpSecurity http) throws Exception {
//        http.csrf().disable().authorizeRequests().anyRequest().authenticated().and().httpBasic();
//        http.headers().frameOptions().disable();
//        //http.headers().addHeaderWriter(new CustomHeaderWriter());
//        //http.headers().addHeaderWriter(new CustomHeaderWriter());
//
//    }
//    @Override
//    public void configure(WebSecurity web) throws Exception {
//        web.ignoring()
//               .antMatchers("/resources/**")
//               .antMatchers("/swagger-ui.html")
//               .antMatchers("/test/**")
//               .antMatchers("/h2-console/**");
//
//                //.antMatchers("/css/**")
//                //.antMatchers("/fonts/**")
//                //.antMatchers("/img/**")
//                //.antMatchers("/js/**")
//                //.antMatchers("/views/**")
//                //.antMatchers("/swagger-resources/configuration/ui")
//                //.antMatchers("/swagger-resources/configuration/security")
//    }
//    @Override
//    public void configure(AuthenticationManagerBuilder auth) throws Exception {
//        auth.userDetails(userDetails())
//              .passwordEncoder(passwordEncoder())
//              .authorities("ROLE_USER")
//              .and()
//              .withUserDetails(userDetails())
//              .and()
//              .withUserDetails(userDetails());
//
//    }
}
