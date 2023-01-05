package com.transfer.transfer.service.customer;

import com.transfer.transfer.model.customer.Customer;
import com.transfer.transfer.model.customer.CustomerDTO;
import com.transfer.transfer.model.customer.CustomerUpdateDTO;
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

