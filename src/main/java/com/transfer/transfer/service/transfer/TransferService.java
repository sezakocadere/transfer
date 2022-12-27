package com.transfer.transfer.service.transfer;

import com.transfer.transfer.model.transfer.Transfer;
import com.transfer.transfer.model.transfer.TransferDTO;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public interface TransferService {
    Transfer post(TransferDTO transferDTO);

    List<Transfer> getAll();
}
