package tn.isg.mssi.BackingRestAPI.Entities;

import lombok.*;

import javax.persistence.*;
import javax.validation.constraints.Email;
import java.util.HashSet;
import java.util.Set;

@Getter //generates all getters
@Setter //generates all setters
@NoArgsConstructor //generates a constructor with no arguments
@RequiredArgsConstructor //generates a constructor with required arguments (NonNull attributes)
@EqualsAndHashCode(onlyExplicitlyIncluded = true)
@Entity//Bank class will be mapped to Bank table on the relational database
public class Bank {
    @Id //the attribute "id" is the primary key of the Bank table
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    //the first added bank will have 1 as primary key value, the next will have 2 ...
    private Integer id;
    @NonNull
    @Column(name = "bank_name",unique = true)
    private String name;
    private String address;
    @NonNull
    @EqualsAndHashCode.Include
    @Email //hh@gmail ==> invalide
    private String email;
    @NonNull
    private String telephoneNumber;

    //specify the relationship between the bank and the account (1-*)
    @OneToMany(mappedBy = "bank", cascade = CascadeType.ALL)
    private Set<Account> accounts = new HashSet<>();
}
