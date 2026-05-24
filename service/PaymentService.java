package org.example.ex3.service;
import org.example.ex3.annotation.RequireManagerApproval;
import org.example.ex3.annotation.RequireOtp;
import org.example.ex3.dto.PaymentRequest;
import org.example.ex3.dto.RefundRequest;
import org.example.ex3.entity.Transaction;
import org.example.ex3.repository.TransactionRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

@Service
@RequiredArgsConstructor
public class PaymentService {

    private final TransactionRepository transactionRepository;

    public Transaction processDomesticPayment(
            PaymentRequest request
    ) {

        Transaction txn = new Transaction();

        txn.setAmount(request.getAmount());
        txn.setCurrency(request.getCurrency());
        txn.setType("DOMESTIC");

        return transactionRepository.save(txn);
    }

    @RequireOtp
    public Transaction processInternationalPayment(
            PaymentRequest request
    ) {

        Transaction txn = new Transaction();

        txn.setAmount(request.getAmount());
        txn.setCurrency(request.getCurrency());
        txn.setType("INTERNATIONAL");

        return transactionRepository.save(txn);
    }

    @RequireManagerApproval
    public Transaction processRefund(
            RefundRequest request
    ) {

        Transaction txn = new Transaction();

        txn.setTransactionCode(
                request.getTransactionCode()
        );

        txn.setAmount(request.getAmount());

        txn.setType("REFUND");

        return transactionRepository.save(txn);
    }

}