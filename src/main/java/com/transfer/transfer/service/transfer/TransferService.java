package com.transfer.transfer.service.transfer;

import com.transfer.transfer.entity.Transfer;
import com.transfer.transfer.dto.transfer.TransferDTO;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public interface TransferService {
    Transfer post(TransferDTO transferDTO);
    List<Transfer> getAll();
}
