package com.transfer.transfer.dto.account;

import com.transfer.transfer.enums.Status;
import lombok.Data;

import javax.persistence.EnumType;
import javax.persistence.Enumerated;
import java.math.BigDecimal;

@Data
public class AccountDTO {
    private BigDecimal balance;
    private String currency;
    private Long customerId;
    @Enumerated(EnumType.STRING)
    private Status status;
}
