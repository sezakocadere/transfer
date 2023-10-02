package com.transfer.transfer.controller;

import com.transfer.transfer.entity.Customer;
import com.transfer.transfer.dto.customer.CustomerDTO;
import com.transfer.transfer.dto.customer.CustomerUpdateDTO;
import com.transfer.transfer.service.customer.CustomerService;
import lombok.RequiredArgsConstructor;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("customers")
@RequiredArgsConstructor
public class CustomerController {
    private final CustomerService costumerService;

    @GetMapping
    public List<Customer> listCostumer() {
        return costumerService.getAll();
    }

    @PostMapping
    public Customer postCostumer(@RequestBody CustomerDTO customerDTO) {
        return costumerService.post(customerDTO);
    }

    @PutMapping(value = "/{customerId}")
    public Customer putCostumer(
            @PathVariable("customerId") Long id, @RequestBody CustomerUpdateDTO customerDTO) {
        return costumerService.update(id, customerDTO);
    }

    @DeleteMapping(value = "/{customerId}")
    public void deleteCostumer(
            @PathVariable("customerId") Long id) {
        costumerService.remove(id);
    }
}

