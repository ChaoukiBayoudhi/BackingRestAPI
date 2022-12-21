package tn.isg.mssi.BackingRestAPI.PlayLoad;

import lombok.Getter;
import lombok.NonNull;
import lombok.RequiredArgsConstructor;
import lombok.Setter;

import java.util.List;
@Getter
@Setter
@RequiredArgsConstructor
public class JwtResponse {
    @NonNull
    private String token;
    private String type = "Bearer";
    @NonNull

    private Long id;
    @NonNull

    private String username;
    @NonNull

    private String email;
    @NonNull

    private List<String> roles;


}
