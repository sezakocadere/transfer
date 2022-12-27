package com.transfer.transfer.model.transfer;

import com.transfer.transfer.enums.Status;
import com.transfer.transfer.enums.TransferType;
import lombok.Data;

import javax.persistence.EnumType;
import javax.persistence.Enumerated;
import java.math.BigDecimal;

@Data
public class TransferDTO {
    private Long senderAccountId;
    private Long receiverAccountId;
    private BigDecimal amount;
    @Enumerated(EnumType.STRING)
    private TransferType transferType;

}
