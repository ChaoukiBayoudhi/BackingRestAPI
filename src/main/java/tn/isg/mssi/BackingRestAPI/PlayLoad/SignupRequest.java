package tn.isg.mssi.BackingRestAPI.PlayLoad;

import lombok.Getter;
import lombok.Setter;

import javax.validation.constraints.Email;
import javax.validation.constraints.NotBlank;
import javax.validation.constraints.Size;
import java.util.Set;
@Getter
@Setter
public class SignupRequest {
    @NotBlank
    @Size(min=6, max = 40)
    private String username;
    @NotBlank
    @Size(max = 50)
    @Email
    private String email;
    @NotBlank
    @Size(min = 12)
    private String password;

    private Set<String> roles;
}
