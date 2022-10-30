package tn.isg.mssi.BackingRestAPI.Entities;

import com.fasterxml.jackson.annotation.JsonFormat;
import lombok.*;
import tn.isg.mssi.BackingRestAPI.Enumerations.AccountState;
import tn.isg.mssi.BackingRestAPI.Enumerations.AccountType;

import javax.persistence.*;
import java.math.BigDecimal;
import java.time.LocalDate;
import java.util.HashSet;
import java.util.Set;

@Getter
@Setter
@NoArgsConstructor
@ToString
@EqualsAndHashCode(onlyExplicitlyIncluded = true)
@Entity
public class Account {
    @Id
    @EqualsAndHashCode.Include
    private Long rib;
    @Column(columnDefinition = "date default current_date")
    @JsonFormat(pattern = "yyyy-MM-dd")
    private LocalDate createdDate;
    @Column(columnDefinition = "real default 20")
    private BigDecimal amount;
    private BigDecimal seuil;
    @Enumerated(EnumType.STRING)
    private AccountState state;
    @Enumerated(EnumType.STRING)
    private AccountType type;
    //specify the relationship between Account and Customer (*-1)
    @ManyToOne
    @JoinColumn(name = "customer_id",referencedColumnName = "id")
    private Customer owner;
    //specify the relationship between Account and Bank (*-1)
    @ManyToOne
    @JoinColumn(name = "bank_id",referencedColumnName = "id")
    private Bank bank;

    //specify the relationship between Account and Transaction (1-*)
    @OneToMany(mappedBy = "account", cascade = CascadeType.ALL)
    private Set<Transaction> transactions = new HashSet<>();

}
