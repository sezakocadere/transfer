package com.transfer.transfer.model.transfer;

import com.transfer.transfer.enums.TransferType;
import com.transfer.transfer.model.account.Account;
import lombok.Data;

import javax.persistence.*;
import java.math.BigDecimal;
import java.time.OffsetDateTime;

@Entity
@Data
public class Transfer {
    @Id
    @GeneratedValue
    private Long id;
    @ManyToOne
    private Account senderAccount;
    @ManyToOne
    private Account receiverAccount;
    private BigDecimal amount;
    private OffsetDateTime executionDate;
    @Enumerated(EnumType.STRING)
    private TransferType transferType;
}
