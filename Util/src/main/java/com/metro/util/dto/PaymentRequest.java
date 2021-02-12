package com.metro.util.dto;

import java.math.BigDecimal;

public class PaymentRequest {

    private String cardNumber;
    private String csv;
    private String exprityDate;
    private BigDecimal amount;

    public String getCardNumber() {
        return cardNumber;
    }

    public void setCardNumber(String cardNumber) {
        this.cardNumber = cardNumber;
    }

    public String getCsv() {
        return csv;
    }

    public void setCsv(String csv) {
        this.csv = csv;
    }

    public String getExprityDate() {
        return exprityDate;
    }

    public void setExprityDate(String exprityDate) {
        this.exprityDate = exprityDate;
    }

    public BigDecimal getAmount() {
        return amount;
    }

    public void setAmount(BigDecimal amount) {
        this.amount = amount;
    }
}
