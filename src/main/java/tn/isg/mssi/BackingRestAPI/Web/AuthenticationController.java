package tn.isg.mssi.BackingRestAPI.Web;

import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import tn.isg.mssi.BackingRestAPI.Entities.User;

@RestController
@RequestMapping("/auth")
public class AuthenticationController {
    @PostMapping("/signup")

    public void signUp() throws Exception {}
    @PostMapping("/signin")
    public void signIn()
    {}
}
