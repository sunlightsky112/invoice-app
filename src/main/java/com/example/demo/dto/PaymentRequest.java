package com.example.demo.dto;

import java.math.BigDecimal;

public class PaymentRequest {
    private String paymentMethod;
    private BigDecimal amount;

    public PaymentRequest() {}

    public PaymentRequest(String paymentMethod, BigDecimal amount) {
        this.paymentMethod = paymentMethod;
        this.amount = amount;
    }

    public String getPaymentMethod() { return paymentMethod; }
    public void setPaymentMethod(String paymentMethod) { this.paymentMethod = paymentMethod; }

    public BigDecimal getAmount() { return amount; }
    public void setAmount(BigDecimal amount) { this.amount = amount; }
}
