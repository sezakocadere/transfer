package com.transfer.transfer.service.account;

import com.transfer.transfer.model.account.Account;
import com.transfer.transfer.model.account.AccountDTO;
import org.springframework.stereotype.Service;

import java.util.List;
@Service
public interface AccountService {
    List<Account> getAllByCostumerId(Long costumerId);

    void remove(Long accountId);

    Account post(AccountDTO accountDTO);
}
