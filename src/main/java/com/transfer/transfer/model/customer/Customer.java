package com.transfer.transfer.model.customer;

import com.transfer.transfer.enums.Status;
import lombok.Data;

import javax.persistence.*;

@Entity
@Data

public class Customer {
    @Id
    @GeneratedValue
    private Long id;

    private String name;
    private String surname;
    private String email;
    private String tckn;
    @Enumerated(EnumType.STRING)
    private Status status;
}
