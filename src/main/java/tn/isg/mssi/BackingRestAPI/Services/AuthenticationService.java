package tn.isg.mssi.BackingRestAPI.Services;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.security.authentication.AuthenticationManager;
import org.springframework.security.authentication.UsernamePasswordAuthenticationToken;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Service;
import tn.isg.mssi.BackingRestAPI.PlayLoad.JwtResponse;
import tn.isg.mssi.BackingRestAPI.PlayLoad.SigninRequest;
import tn.isg.mssi.BackingRestAPI.PlayLoad.SignupRequest;
import tn.isg.mssi.BackingRestAPI.Repositories.RoleRepository;
import tn.isg.mssi.BackingRestAPI.Repositories.UserRepository;
import tn.isg.mssi.BackingRestAPI.Security.services.UserDetailsImpl;
import tn.isg.mssi.BackingRestAPI.Security.jwt.JwtUtils;

import java.util.List;

@Service
public class AuthenticationService {
    @Autowired

    private  UserRepository userRepository;

    @Autowired

    private  RoleRepository roleRepository;
    @Autowired

    private  PasswordEncoder passwordEncoder;
    @Autowired

    private  JwtUtils jwtUtils;
    @Autowired

    private  AuthenticationManager authenticationManager;
    public ResponseEntity<?> signIn(SigninRequest signinRequest) throws Exception {
        //get the authentication object using given credentials (username and password)
       Authentication authentication=authenticationManager.authenticate(
                new UsernamePasswordAuthenticationToken(
                        signinRequest.getUsername(),
                        signinRequest.getPassword()
                )
        );
       //set the authentication object in the security context
       SecurityContextHolder.getContext().setAuthentication(authentication);
       //generate the jwt token
        String jwtToken=jwtUtils.generateJwtToken(authentication);
        //get the user details
        UserDetailsImpl userDetails=(UserDetailsImpl) authentication.getPrincipal();
        //get user roles
        List<String> roles=userDetails.getAuthorities().stream()
                .map(r->r.getAuthority())
                .toList();
        return ResponseEntity.ok().body(new JwtResponse(
                jwtToken,userDetails.getId(),userDetails.getUsername(),userDetails.getEmail(),roles)
        );
    }
    public ResponseEntity<?> signUp(SignupRequest signupRequest) throws Exception {

        return null;
    }

}
