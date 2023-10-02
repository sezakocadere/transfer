package com.transfer.transfer.controller;

import com.transfer.transfer.entity.Account;
import com.transfer.transfer.dto.account.AccountDTO;
import com.transfer.transfer.service.account.AccountService;
import lombok.RequiredArgsConstructor;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("accounts")
@RequiredArgsConstructor
public class AccountController {
    private final AccountService accountService;

    @GetMapping(value = "/{customerId}")
    public List<Account> listAccount(
            @PathVariable("customerId") Long id) {
        return accountService.getAllByCostumerId(id);
    }

    @PostMapping
    public Account postAccount(@RequestBody AccountDTO accountDTO) {
        return accountService.post(accountDTO);
    }

    @DeleteMapping(value = "/{accountId}")
    public void deleteAccount(
            @PathVariable("accountId") Long id) {
        accountService.remove(id);
    }
}
