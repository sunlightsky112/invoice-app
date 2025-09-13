package com.example.demo.service;

import com.example.demo.dto.*;
import com.example.demo.model.*;
import com.example.demo.repository.InvoiceRepository;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.stream.Collectors;

@Service
public class InvoiceService {
    private final InvoiceRepository invoiceRepo;

    public InvoiceService(InvoiceRepository invoiceRepo) {
        this.invoiceRepo = invoiceRepo;
    }

    public Invoice createInvoice(InvoiceRequest request) {
        Invoice invoice = new Invoice(request.getCustomerName());

        List<LineItem> items = request.getLineItems().stream().map(li -> {
            LineItem item = new LineItem();
            item.setDescription(li.getDescription());
            item.setPrice(li.getPrice());
            item.setInvoice(invoice);
            return item;
        }).collect(Collectors.toList());

        invoice.setLineItems(items);
        return invoiceRepo.save(invoice);
    }

    public Invoice getInvoice(Long id) {
        return invoiceRepo.findById(id).orElseThrow(() -> new RuntimeException("Invoice not found"));
    }

    public List<Invoice> searchInvoices(String customerName) {
        return invoiceRepo.findByCustomerNameContainingIgnoreCase(customerName);
    }

    public Invoice addLineItems(Long invoiceId, List<LineItemRequest> items) {
        Invoice invoice = getInvoice(invoiceId);
        items.forEach(req -> {
            LineItem item = new LineItem();
            item.setDescription(req.getDescription());
            item.setPrice(req.getPrice());
            item.setInvoice(invoice);
            invoice.getLineItems().add(item);
        });
        return invoiceRepo.save(invoice);
    }

    public Invoice payInvoice(Long invoiceId, PaymentRequest request) {
        Invoice invoice = getInvoice(invoiceId);
        Payment payment = new Payment(request.getPaymentMethod(), request.getAmount());
        invoice.setPayment(payment);
        invoice.setPaid(true);
        return invoiceRepo.save(invoice);
    }
}
