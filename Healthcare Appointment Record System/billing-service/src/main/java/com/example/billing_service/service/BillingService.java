package com.example.billing_service.service;

import com.example.billing_service.model.Billing;
import com.example.billing_service.repository.BillingRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class BillingService {

    @Autowired
    private BillingRepository billingRepository;

    public Billing generateBilling(Billing billing) {
        if (billing.getStatus() == null) {
            billing.setStatus("UNPAID");
        }
        if (billing.getIssuedDate() == null) {
            billing.setIssuedDate(java.time.LocalDate.now());
        }
        return billingRepository.save(billing);
    }

    public List<Billing> getAllBillings() {
        return billingRepository.findAll();
    }

    public Optional<Billing> getBillingById(String id) {
        return billingRepository.findById(id);
    }

    public List<Billing> getBillingsByPatientId(String patientId) {
        return billingRepository.findByPatientId(patientId);
    }

    public List<Billing> getBillingsByStatus(String status) {
        return billingRepository.findByStatus(status);
    }

    public Billing updateBilling(String id, Billing updatedBilling) {
        return billingRepository.findById(id)
            .map(billing -> {
                billing.setPatientId(updatedBilling.getPatientId());
                billing.setAppointmentId(updatedBilling.getAppointmentId());
                billing.setAmount(updatedBilling.getAmount());
                billing.setStatus(updatedBilling.getStatus());
                billing.setInsuranceClaimStatus(updatedBilling.getInsuranceClaimStatus());
                billing.setIssuedDate(updatedBilling.getIssuedDate());
                return billingRepository.save(billing);
            })
            .orElseThrow(() -> new RuntimeException("Billing record not found"));
    }

    public void deleteBilling(String id) {
        billingRepository.deleteById(id);
    }
}
