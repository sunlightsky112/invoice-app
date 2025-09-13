package com.example.demo.controller;

import com.example.demo.dto.*;
import com.example.demo.model.Invoice;
import com.example.demo.service.InvoiceService;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import io.swagger.v3.oas.annotations.Operation;
import io.swagger.v3.oas.annotations.responses.ApiResponses;
import io.swagger.v3.oas.annotations.responses.ApiResponse;
import io.swagger.v3.oas.annotations.Parameter;
import io.swagger.v3.oas.annotations.tags.Tag;

import java.util.List;

@RestController
@RequestMapping("/invoices")
@Tag(name = "Invoices", description = "Operations for managing invoices and payments")
public class InvoiceController {
    private final InvoiceService invoiceService;

    public InvoiceController(InvoiceService invoiceService) {
        this.invoiceService = invoiceService;
    }

    @Operation(summary = "Create a new invoice with line items")
    @ApiResponses({
        @ApiResponse(responseCode = "200", description = "Invoice created successfully"),
        @ApiResponse(responseCode = "400", description = "Invalid input")
    })
    @PostMapping
    public ResponseEntity<Invoice> createInvoice(@RequestBody InvoiceRequest request) {
        return ResponseEntity.ok(invoiceService.createInvoice(request));
    }

    @Operation(summary = "Get invoice by ID")
    @ApiResponses({
        @ApiResponse(responseCode = "200", description = "Invoice retrieved successfully"),
        @ApiResponse(responseCode = "404", description = "Invoice not found")
    })
    @GetMapping("/{id}")
    public ResponseEntity<Invoice> getInvoice(@PathVariable Long id) {
        return ResponseEntity.ok(invoiceService.getInvoice(id));
    }

    @Operation(summary = "Search invoices by customer name")
    @ApiResponses({
        @ApiResponse(responseCode = "200", description = "Matching invoices returned")
    })
    @GetMapping
    public ResponseEntity<List<Invoice>> searchInvoices(@RequestParam String customerName) {
        return ResponseEntity.ok(invoiceService.searchInvoices(customerName));
    }

    @Operation(summary = "Add line items to an existing invoice")
    @ApiResponses({
        @ApiResponse(responseCode = "200", description = "Line items added successfully"),
        @ApiResponse(responseCode = "404", description = "Invoice not found")
    })
    @PutMapping("/{id}/line-items")
    public ResponseEntity<Invoice> addLineItems(@PathVariable Long id, @RequestBody List<LineItemRequest> items) {
        return ResponseEntity.ok(invoiceService.addLineItems(id, items));
    }

    @Operation(summary = "Mark invoice as paid")
    @ApiResponses({
        @ApiResponse(responseCode = "200", description = "Invoice marked as paid"),
        @ApiResponse(responseCode = "404", description = "Invoice not found")
    })
    @PostMapping("/{id}/pay")
    public ResponseEntity<Invoice> payInvoice(@PathVariable Long id, @RequestBody PaymentRequest request) {
        return ResponseEntity.ok(invoiceService.payInvoice(id, request));
    }
}
