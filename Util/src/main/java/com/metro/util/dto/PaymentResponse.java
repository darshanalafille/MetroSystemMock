package com.metro.util.dto;

import com.fasterxml.jackson.annotation.JsonInclude;

import java.util.List;

@JsonInclude(JsonInclude.Include.NON_NULL)
public class PaymentResponse {

    private String txnId;
    private Boolean status;
    private List<String> failResons;

    public String getTxnId() {
        return txnId;
    }

    public void setTxnId(String txnId) {
        this.txnId = txnId;
    }

    public Boolean getStatus() {
        return status;
    }

    public void setStatus(Boolean status) {
        this.status = status;
    }

    public List<String> getFailResons() {
        return failResons;
    }

    public void setFailResons(List<String> failResons) {
        this.failResons = failResons;
    }
}
