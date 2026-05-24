package org.example.ex3.controller;
import org.example.ex3.dto.PaymentRequest;
import org.example.ex3.dto.RefundRequest;
import org.example.ex3.entity.Transaction;
import org.example.ex3.service.PaymentService;

import lombok.RequiredArgsConstructor;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/api/payments")
@RequiredArgsConstructor
public class PaymentController {

    private final PaymentService paymentService;

    @PostMapping("/domestic")
    public Transaction domesticPayment(
            @Valid @RequestBody PaymentRequest request
    ) {

        return paymentService
                .processDomesticPayment(request);

    }

    @PostMapping("/international")
    public Transaction internationalPayment(
            @Valid @RequestBody PaymentRequest request
    ) {

        return paymentService
                .processInternationalPayment(request);

    }

    @PostMapping("/refund")
    public Transaction refund(
            @Valid @RequestBody RefundRequest request
    ) {

        return paymentService
                .processRefund(request);

    }

}