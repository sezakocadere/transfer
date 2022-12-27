package com.transfer.transfer.repository;

import com.transfer.transfer.enums.Status;
import com.transfer.transfer.model.account.Account;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;

import java.util.List;

public interface AccountRepository extends JpaRepository<Account, Long> {

    @Query("SELECT u FROM Account u WHERE u.customer.id=:customerId")
    List<Account> getAllByCostumer(@Param("customerId") Long customerId);

    @Query("SELECT u FROM Account u WHERE u.id=:accountId")
    Account getAccountById(@Param("accountId") Long accountId);

    long countByStatusAndCustomerId(Status status, Long customerId);
}