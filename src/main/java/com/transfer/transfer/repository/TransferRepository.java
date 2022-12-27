package com.transfer.transfer.repository;

import com.transfer.transfer.model.transfer.Transfer;
import org.springframework.data.jpa.repository.JpaRepository;

public interface TransferRepository extends JpaRepository<Transfer, Long> {
}
