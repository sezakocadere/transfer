package com.transfer.transfer.dto.customer;

import com.transfer.transfer.enums.Status;
import lombok.Data;

import javax.persistence.EnumType;
import javax.persistence.Enumerated;

@Data
public class CustomerUpdateDTO {
    private String name;
    private String surname;
    private String email;
    @Enumerated(EnumType.STRING)
    private Status status;
}
