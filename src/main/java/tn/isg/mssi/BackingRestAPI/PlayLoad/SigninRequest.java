package tn.isg.mssi.BackingRestAPI.PlayLoad;

import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
public class SigninRequest {
    private String username;
    private String password;
}
