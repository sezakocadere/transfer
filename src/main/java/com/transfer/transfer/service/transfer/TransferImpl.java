package com.transfer.transfer.service.transfer;

import com.transfer.transfer.enums.Status;
import com.transfer.transfer.enums.TransferType;
import com.transfer.transfer.error.BadRequestValue;
import com.transfer.transfer.error.NotFoundObject;
import com.transfer.transfer.model.account.Account;
import com.transfer.transfer.model.transfer.Transfer;
import com.transfer.transfer.model.transfer.TransferDTO;
import com.transfer.transfer.repository.AccountRepository;
import com.transfer.transfer.repository.TransferRepository;
import lombok.AllArgsConstructor;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.math.BigDecimal;
import java.time.Clock;
import java.time.OffsetDateTime;
import java.util.List;
import java.util.Objects;

@AllArgsConstructor
@Service
public class TransferImpl implements TransferService {
    public final AccountRepository accountRepository;
    public final TransferRepository transferRepository;

    @Override
    @Transactional
    public Transfer post(TransferDTO transferDTO) {
        Account senderAccount = accountRepository.findById(transferDTO.getSenderAccountId()).orElseThrow(() -> new NotFoundObject("Sender Account ID Not Found"));
        Account receiverAccount = accountRepository.findById(transferDTO.getReceiverAccountId()).orElseThrow(() -> new NotFoundObject("Receiver Account ID Not Found"));

        BigDecimal senderAccountBalance = senderAccount.getBalance();
        BigDecimal transferAmount = transferDTO.getAmount();

        if ((senderAccount.getStatus().equals(Status.PASSIVE) || receiverAccount.getStatus().equals(Status.PASSIVE))) {
            throw new NotFoundObject("Transfer is failed because account's status is passive");
        }
        if (Objects.equals(transferDTO.getSenderAccountId(), transferDTO.getReceiverAccountId())) {
            throw new BadRequestValue("Transfer is failed because you can not transfer from same account");
        }
        if (!senderAccount.getCurrency().equalsIgnoreCase(receiverAccount.getCurrency())) {
            throw new BadRequestValue("Transfer is failed because of currencies are not the same.");
        }
        if (senderAccountBalance.compareTo(transferAmount) < 0) {
            throw new BadRequestValue("Transfer is failed because of balance is not enough for transfer ");
        }

        senderAccount.setBalance(senderAccountBalance.subtract(transferAmount));
        receiverAccount.setBalance(receiverAccount.getBalance().add(transferAmount));

        boolean isSameCustomerId = Objects.equals(senderAccount.getCustomer().getId(), receiverAccount.getCustomer().getId());
        Transfer transfer = new Transfer();
        transfer.setAmount(transferDTO.getAmount());
        transfer.setReceiverAccount(accountRepository.getAccountById(transferDTO.getReceiverAccountId()));
        transfer.setSenderAccount(accountRepository.getAccountById(transferDTO.getSenderAccountId()));
        transfer.setTransferType(isSameCustomerId ? TransferType.TRANSFER_BETWEEN_SAME_CUSTOMER : TransferType.TRANSFER_BETWEEN_DIFFERENT_CUSTOMER);
        transfer.setExecutionDate(OffsetDateTime.now(Clock.systemUTC()));
        transferRepository.save(transfer);
        accountRepository.save(senderAccount);
        accountRepository.save(receiverAccount);
        return transfer;
    }

    @Override
    public List<Transfer> getAll() {
        return transferRepository.findAll();
    }
}
