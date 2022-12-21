package tn.isg.mssi.BackingRestAPI.Entities;

import com.fasterxml.jackson.annotation.JsonFormat;
import lombok.*;

import javax.persistence.*;
import java.time.LocalDate;
import java.util.HashSet;
import java.util.Set;

@Getter
@Setter
@NoArgsConstructor
@RequiredArgsConstructor
@ToString
@EqualsAndHashCode(onlyExplicitlyIncluded = true)
@Entity

//@PrimaryKeyJoinColumn(name="id")
public class Customer {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @NonNull
    private String name;
    @NonNull
    private String familyName;
    @NonNull
    @Column(length = 8)
    @EqualsAndHashCode.Include
    private String cin;
    @JsonFormat(pattern = "yyyy-MM-dd")
    private LocalDate birthDate;


    //specify the relationship between Customer and Account (1-*)
    @OneToMany(mappedBy = "owner", cascade = CascadeType.ALL)
    private Set<Account> accounts = new HashSet<>();
}
