package tn.isg.mssi.BackingRestAPI.Entities;

import lombok.*;
import tn.isg.mssi.BackingRestAPI.Enumerations.ERole;

import javax.persistence.*;
import java.util.HashSet;
import java.util.Set;

@Getter
@Setter
@NoArgsConstructor
@RequiredArgsConstructor
@ToString
@EqualsAndHashCode
@Entity
@Table(name="roles")
public class Role {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer id;
    @NonNull
    @Enumerated(EnumType.STRING)
    @EqualsAndHashCode.Include
    private ERole name;
    @ManyToMany(mappedBy = "roles")
    private Set<User> users = new HashSet<>();

}
