package com.transfer.transfer.service.customer;

import com.transfer.transfer.enums.Status;
import com.transfer.transfer.error.BadRequestValue;
import com.transfer.transfer.error.NotFoundObject;
import com.transfer.transfer.model.account.Account;
import com.transfer.transfer.model.customer.Customer;
import com.transfer.transfer.model.customer.CustomerDTO;
import com.transfer.transfer.model.customer.CustomerUpdateDTO;
import com.transfer.transfer.repository.AccountRepository;
import com.transfer.transfer.repository.CustomerRepository;
import lombok.AllArgsConstructor;
import org.modelmapper.ModelMapper;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

@AllArgsConstructor
@Service
public class CustomerServiceImpl implements CostumerService {
    public final CustomerRepository customerRepository;
    private final AccountRepository accountRepository;

    @Transactional
    @Override
    public Customer get(Long id) {
        return getCustomer(id);
    }

    @Transactional
    @Override
    public List<Customer> getAll() {
        return customerRepository.findAll();
    }

    @Transactional
    @Override
    public Customer post(CustomerDTO customerDTO) {
        ModelMapper modelMapper = new ModelMapper();
        Customer customer = modelMapper.map(customerDTO, Customer.class);
        customer.setStatus(Status.ACTIVE);
        customerRepository.save(customer);
        return customer;
    }

    @Transactional
    @Override
    public void remove(Long id) {
        Customer customer = getCustomer(id);
        long countAccount = accountRepository.countByStatusAndCustomerId(Status.ACTIVE, id);
        if(countAccount > 0 ){
            throw new BadRequestValue("Can not remove customer because of it has number of active account is :" + countAccount);
        }
        customer.setStatus(Status.PASSIVE);
        customerRepository.save(customer);
    }

    private Customer getCustomer(Long id) {
        Customer customer = customerRepository.findById(id).orElseThrow(() -> new NotFoundObject("Customer Not Found"));
        return customer;
    }

    @Transactional
    @Override
    public Customer update(Long id, CustomerUpdateDTO customerDTO) {
        Customer customer = getCustomer(id);
        customer.setName(customerDTO.getName());
        customer.setSurname(customerDTO.getSurname());
        customer.setEmail(customerDTO.getEmail());
        customer.setStatus(customerDTO.getStatus());
        customerRepository.save(customer);
        return customer;
    }
}
