package com.example.demo.dto;

import java.util.List;
import java.math.BigDecimal;

public class InvoiceRequest {
    private String customerName;
    private List<LineItemRequest> lineItems;

    public InvoiceRequest() {}

    public InvoiceRequest(String customerName, List<LineItemRequest> lineItems) {
        this.customerName = customerName;
        this.lineItems = lineItems;
    }

    public String getCustomerName() { return customerName; }
    public void setCustomerName(String customerName) { this.customerName = customerName; }

    public List<LineItemRequest> getLineItems() { return lineItems; }
    public void setLineItems(List<LineItemRequest> lineItems) { this.lineItems = lineItems; }
}
