package com.example.billing_service.model;

import org.springframework.data.annotation.Id;
import org.springframework.data.mongodb.core.mapping.Document;

import java.math.BigDecimal;
import java.time.LocalDate;

@Document(collection = "billings")
public class Billing {

    @Id
    private String id;

    private String patientId;
    private String appointmentId;
    private BigDecimal amount;
    private String status; // PAID, UNPAID
    private String insuranceClaimStatus; // PENDING, APPROVED, REJECTED
    private LocalDate issuedDate;

    public Billing() {}

    public Billing(String id, String patientId, String appointmentId, BigDecimal amount, String status,
                   String insuranceClaimStatus, LocalDate issuedDate) {
        this.id = id;
        this.patientId = patientId;
        this.appointmentId = appointmentId;
        this.amount = amount;
        this.status = status;
        this.insuranceClaimStatus = insuranceClaimStatus;
        this.issuedDate = issuedDate;
    }

    // Getters and setters

    public String getId() { return id; }
    public void setId(String id) { this.id = id; }

    public String getPatientId() { return patientId; }
    public void setPatientId(String patientId) { this.patientId = patientId; }

    public String getAppointmentId() { return appointmentId; }
    public void setAppointmentId(String appointmentId) { this.appointmentId = appointmentId; }

    public BigDecimal getAmount() { return amount; }
    public void setAmount(BigDecimal amount) { this.amount = amount; }

    public String getStatus() { return status; }
    public void setStatus(String status) { this.status = status; }

    public String getInsuranceClaimStatus() { return insuranceClaimStatus; }
    public void setInsuranceClaimStatus(String insuranceClaimStatus) { this.insuranceClaimStatus = insuranceClaimStatus; }

    public LocalDate getIssuedDate() { return issuedDate; }
    public void setIssuedDate(LocalDate issuedDate) { this.issuedDate = issuedDate; }
}
