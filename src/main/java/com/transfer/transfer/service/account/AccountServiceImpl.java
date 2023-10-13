package com.transfer.transfer.service.account;

import com.transfer.transfer.enums.Status;
import com.transfer.transfer.error.BadRequestValue;
import com.transfer.transfer.error.NotFoundObject;
import com.transfer.transfer.entity.Account;
import com.transfer.transfer.dto.account.AccountDTO;
import com.transfer.transfer.entity.Customer;
import com.transfer.transfer.repository.AccountRepository;
import com.transfer.transfer.repository.CustomerRepository;
import lombok.AllArgsConstructor;
import org.springframework.stereotype.Service;

import java.math.BigDecimal;
import java.util.List;

@AllArgsConstructor
@Service
public class AccountServiceImpl implements AccountService {
    public final AccountRepository accountRepository;
    public final CustomerRepository customerRepository;


    @Override
    public List<Account> getAllByCostumerId(Long costumerId) {
        Customer customer = customerRepository.findById(costumerId).orElseThrow(() -> new NotFoundObject("Customer Not Found"));
        return accountRepository.getAllByCostumer(costumerId);
    }

    @Override
    public void remove(Long accountId) {
        Account account = accountRepository.findById(accountId).orElseThrow(() -> new NotFoundObject("Account Not Found"));
        if (account.getBalance().compareTo(BigDecimal.ZERO) != 0) {
            throw new BadRequestValue("Can not remove account because of it has balance. :" + account.getBalance());
        }
        account.setStatus(Status.PASSIVE);
        accountRepository.save(account);
    }

    @Override
    public Account post(AccountDTO accountDTO) {
        Customer customer = customerRepository.findById(accountDTO.getCustomerId()).orElseThrow(() -> new NotFoundObject("Customer Not Found"));

        Account account = new Account();
        account.setBalance(accountDTO.getBalance());
        account.setCurrency(accountDTO.getCurrency());
        account.setCustomer(customer);
        account.setStatus(Status.ACTIVE);
        accountRepository.save(account);
        return account;
    }
}
