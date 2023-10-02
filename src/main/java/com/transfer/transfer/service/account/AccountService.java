package com.transfer.transfer.service.account;

import com.transfer.transfer.entity.Account;
import com.transfer.transfer.dto.account.AccountDTO;
import org.springframework.stereotype.Service;

import java.util.List;
@Service
public interface AccountService {
    List<Account> getAllByCostumerId(Long costumerId);

    void remove(Long accountId);

    Account post(AccountDTO accountDTO);
}
