package com.transfer.transfer.entity;

import com.transfer.transfer.enums.Status;
import lombok.Data;

import javax.persistence.*;
import java.math.BigDecimal;

@Entity
@Data
public class Account {

    @Id
    @GeneratedValue
    private Long id;

    private BigDecimal balance;
    private String currency;
    @ManyToOne
    private Customer customer;
    @Enumerated(EnumType.STRING)
    private Status status;
}
