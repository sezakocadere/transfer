package com.transfer.transfer.controller;

import com.transfer.transfer.entity.Transfer;
import com.transfer.transfer.dto.transfer.TransferDTO;
import com.transfer.transfer.service.transfer.TransferService;
import lombok.RequiredArgsConstructor;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("transfer")
@RequiredArgsConstructor
public class TransferController {
    private final TransferService transferService;

    @GetMapping
    public List<Transfer> listCostumer() {
        return transferService.getAll();
    }

    @PostMapping
    public Transfer TransferRequest(@RequestBody TransferDTO transferDTO) {
        return transferService.post(transferDTO);
    }
}
