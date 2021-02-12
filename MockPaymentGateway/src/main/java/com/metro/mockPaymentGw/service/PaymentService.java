package com.metro.mockPaymentGw.service;

import com.metro.util.dto.PaymentRequest;
import com.metro.util.dto.PaymentResponse;
import org.springframework.stereotype.Service;

import java.math.BigDecimal;
import java.util.ArrayList;
import java.util.List;

@Service
public class PaymentService {

    private final List<String> cardNumbers = List.of("4111111111111111","4222222222222","4012888888881881");
    private final BigDecimal maxAmountAccepted = BigDecimal.valueOf(1000);

    public PaymentResponse doPayment(PaymentRequest request){
        List<String> failResons = new ArrayList<>();
        boolean status = false;
        if(cardNumbers.contains(request.getCardNumber()) && request.getAmount().compareTo(maxAmountAccepted) < 0){
            status = true;
        }else {
            failResons = List.of("Invalied CC Number","Max amount exceeded");
        }
        PaymentResponse response = new PaymentResponse();
        response.setTxnId(String.valueOf(System.currentTimeMillis()));
        response.setStatus(status);
        response.setFailResons(failResons);
        return response;
    }

}
