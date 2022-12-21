package tn.isg.mssi.BackingRestAPI.Web;

import lombok.RequiredArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import tn.isg.mssi.BackingRestAPI.Entities.User;
import tn.isg.mssi.BackingRestAPI.PlayLoad.SigninRequest;
import tn.isg.mssi.BackingRestAPI.PlayLoad.SignupRequest;
import tn.isg.mssi.BackingRestAPI.Services.AuthenticationService;

import javax.validation.Valid;

@RestController
@RequestMapping("api/auth")
@RequiredArgsConstructor
public class AuthenticationController {
    private final AuthenticationService authenticationService;
    @PostMapping("/signup")

    public ResponseEntity<?> signUp(@Valid @RequestBody SignupRequest signupRequest) throws Exception {
        return authenticationService.signUp(signupRequest);
    }
    @PostMapping("/signin")
    public ResponseEntity<?> signIn(@Valid @RequestBody SigninRequest signinRequest) throws Exception
    {
        return authenticationService.signIn(signinRequest);
    }
}
