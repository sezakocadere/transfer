package com.transfer.transfer;

import com.transfer.transfer.enums.Status;
import com.transfer.transfer.model.customer.Customer;
import com.transfer.transfer.model.customer.CustomerUpdateDTO;
import com.transfer.transfer.repository.AccountRepository;
import com.transfer.transfer.repository.CustomerRepository;
import com.transfer.transfer.service.customer.CustomerService;
import com.transfer.transfer.service.customer.CustomerServiceImpl;
import org.assertj.core.api.JUnitSoftAssertions;
import org.junit.Assert;
import org.junit.Before;
import org.junit.Rule;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.mockito.Mock;
import org.mockito.junit.MockitoJUnitRunner;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

import static org.mockito.Mockito.when;

@RunWith(MockitoJUnitRunner.Silent.class)
public class CustomerServiceImplTest {
    @Rule
    public final JUnitSoftAssertions softly = new JUnitSoftAssertions();

    private CustomerService customerService;

    @Mock
    private CustomerRepository customerRepository;
    @Mock
    private AccountRepository accountRepository;

    @Before
    public void create() {
        customerService = new CustomerServiceImpl(customerRepository, accountRepository);
    }

    private Customer prepareCustomer() {
        Customer customer = new Customer();
        customer.setId(20L);
        customer.setName("Seza");
        customer.setSurname("Kocadere");
        customer.setEmail("seza.kocadere@gmail.com");
        customer.setTckn("202020");
        customer.setStatus(Status.ACTIVE);
        return customer;
    }

    @Test
    public void getAllCustomers() {
        // Arrange
        Customer customer = prepareCustomer();
        List<Customer> customerList = new ArrayList<>();
        customerList.add(customer);
        when(customerRepository.findAll()).thenReturn(customerList);

        // Act
        List<Customer> responseCustomerList = customerService.getAll();

        // Assert
        Assert.assertEquals(1, responseCustomerList.size());
        softly.assertThat(responseCustomerList.size()).isEqualTo(customerList.size());
        softly.assertThat(responseCustomerList.get(0).getName()).isEqualTo(customer.getName());
    }

    @Test
    public void updateCustomer() {
        // Arrange
        CustomerUpdateDTO customerUpdateDTO = new CustomerUpdateDTO();
        customerUpdateDTO.setName("Name");
        customerUpdateDTO.setSurname("Surname");
        customerUpdateDTO.setEmail("email@gmail.com");
        customerUpdateDTO.setStatus(Status.ACTIVE);
        Customer customer = prepareCustomer();
        when(customerRepository.findById(20L)).thenReturn(Optional.of((customer)));

        // Act
        Customer response = customerService.update(20L, customerUpdateDTO);

        // Assert
        softly.assertThat(response.getName()).isEqualTo(customerUpdateDTO.getName());
        softly.assertThat(response.getSurname()).isEqualTo(customerUpdateDTO.getSurname());
        softly.assertThat(response.getEmail()).isEqualTo(customerUpdateDTO.getEmail());
        softly.assertThat(response.getStatus()).isEqualTo(customerUpdateDTO.getStatus());
    }

    @Test
    public void getCustomerById() {
        // Arrange
        Customer customer = prepareCustomer();
        when(customerRepository.findById(customer.getId())).thenReturn(Optional.of(customer));

        // Act
        Customer responseCustomer = customerService.get(customer.getId());

        // Assert
        softly.assertThat(responseCustomer.getId()).isEqualTo(customer.getId());
    }

    @Test
    public void removeCustomer() {
        // Arrange
        Customer customer = prepareCustomer();
        when(customerRepository.findById(customer.getId())).thenReturn(Optional.of(customer));

        //Act
        customerService.remove(customer.getId());

        // Assert
        softly.assertThat(customer.getStatus()).isEqualTo(Status.PASSIVE);
    }
}