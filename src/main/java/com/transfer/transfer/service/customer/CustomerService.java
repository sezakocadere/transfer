package com.transfer.transfer.service.customer;

import com.transfer.transfer.entity.Customer;
import com.transfer.transfer.dto.customer.CustomerDTO;
import com.transfer.transfer.dto.customer.CustomerUpdateDTO;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public interface CustomerService {
    Customer get(Long id);

    List<Customer> getAll();

    Customer post(CustomerDTO customerDTO);

    void remove(Long id);

    Customer update(Long id, CustomerUpdateDTO customer);
}

