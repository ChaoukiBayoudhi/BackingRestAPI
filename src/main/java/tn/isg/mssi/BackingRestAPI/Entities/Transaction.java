package tn.isg.mssi.BackingRestAPI.Entities;

import com.fasterxml.jackson.annotation.JsonFormat;
import lombok.*;
import tn.isg.mssi.BackingRestAPI.Enumerations.TransactionType;

import javax.persistence.*;
import java.math.BigDecimal;
import java.time.LocalDate;
import java.time.LocalDateTime;

@Getter
@Setter
@NoArgsConstructor
@RequiredArgsConstructor
@ToString
@EqualsAndHashCode(onlyExplicitlyIncluded = true)
@Entity
public class Transaction {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    @JsonFormat(pattern = "yyyy-MM-dd hh:mm:ss")
    @NonNull
    private LocalDateTime dateTime;
    @NonNull
    private BigDecimal amount;
    @Enumerated(EnumType.STRING)
    @NonNull
    private TransactionType type;
    private Long ribOtherAccount;// used in case of Virement from another account
    private String message;

    //specify the relationship between Account and Bank (*-1)
    @ManyToOne
    @JoinColumn(name = "account_rib",referencedColumnName = "rib")
    private Account account;
}
