package com.example.demo.model;

import jakarta.persistence.*;
import java.math.BigDecimal;
import java.time.LocalDate;

@Entity
public class Payment {
    @Id @GeneratedValue
    private Long id;

    private LocalDate paidAt = LocalDate.now();
    private String paymentMethod;
    private BigDecimal amount;

    public Payment() {}

    public Payment(String paymentMethod, BigDecimal amount) {
        this.paidAt = LocalDate.now();
        this.paymentMethod = paymentMethod;
        this.amount = amount;
    }

    public Long getId() { return id; }
    public LocalDate getPaidAt() { return paidAt; }

    public String getPaymentMethod() { return paymentMethod; }
    public void setPaymentMethod(String paymentMethod) { this.paymentMethod = paymentMethod; }

    public BigDecimal getAmount() { return amount; }
    public void setAmount(BigDecimal amount) { this.amount = amount; }
}
