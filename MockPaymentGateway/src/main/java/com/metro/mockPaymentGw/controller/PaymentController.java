package com.metro.mockPaymentGw.controller;

import com.metro.mockPaymentGw.service.PaymentService;
import com.metro.util.dto.PaymentRequest;
import com.metro.util.dto.PaymentResponse;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class PaymentController {

    @Autowired
    PaymentService paymentService;

    @PutMapping("/api/payment")
    public ResponseEntity<PaymentResponse> doPayment(@RequestBody PaymentRequest paymentRequest){
        return ResponseEntity.ok(paymentService.doPayment(paymentRequest));
    }

}
