package com.example.billing_service.controller;

import com.example.billing_service.model.Billing;
import com.example.billing_service.service.BillingService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/billing")
public class BillingController {

    @Autowired
    private BillingService billingService;

    @PostMapping("/billings")
    public ResponseEntity<Billing> generateBilling(@RequestBody Billing billing) {
        Billing saved = billingService.generateBilling(billing);
        return ResponseEntity.ok(saved);
    }

    @GetMapping("/billings")
    public ResponseEntity<List<Billing>> getAllBillings() {
        return ResponseEntity.ok(billingService.getAllBillings());
    }

    @GetMapping("/billings/{id}")
    public ResponseEntity<Billing> getBillingById(@PathVariable String id) {
        return billingService.getBillingById(id)
            .map(ResponseEntity::ok)
            .orElse(ResponseEntity.notFound().build());
    }

    @GetMapping("/billings/patient/{patientId}")
    public ResponseEntity<List<Billing>> getBillingsByPatientId(@PathVariable String patientId) {
        return ResponseEntity.ok(billingService.getBillingsByPatientId(patientId));
    }

    @GetMapping("/billings/status/{status}")
    public ResponseEntity<List<Billing>> getBillingsByStatus(@PathVariable String status) {
        return ResponseEntity.ok(billingService.getBillingsByStatus(status));
    }

    @PutMapping("/billings/{id}")
    public ResponseEntity<Billing> updateBilling(@PathVariable String id, @RequestBody Billing billing) {
        try {
            Billing updated = billingService.updateBilling(id, billing);
            return ResponseEntity.ok(updated);
        } catch (RuntimeException e) {
            return ResponseEntity.notFound().build();
        }
    }

    @DeleteMapping("/billings/{id}")
    public ResponseEntity<Void> deleteBilling(@PathVariable String id) {
        billingService.deleteBilling(id);
        return ResponseEntity.noContent().build();
    }
}
