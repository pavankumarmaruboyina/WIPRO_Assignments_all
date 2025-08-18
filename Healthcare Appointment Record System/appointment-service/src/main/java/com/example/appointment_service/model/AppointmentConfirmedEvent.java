package com.example.appointment_service.model;

public class AppointmentConfirmedEvent {

    private String appointmentId;
    private String patientId;
    private String doctorId;
    private String slotId;

    public AppointmentConfirmedEvent() {}

    public AppointmentConfirmedEvent(Appointment appointment) {
        this.appointmentId = appointment.getId();
        this.patientId = appointment.getPatientId();
        this.doctorId = appointment.getDoctorId();
        this.slotId = appointment.getSlotId();
    }

    // Getters and setters

    public String getAppointmentId() { return appointmentId; }
    public void setAppointmentId(String appointmentId) { this.appointmentId = appointmentId; }

    public String getPatientId() { return patientId; }
    public void setPatientId(String patientId) { this.patientId = patientId; }

    public String getDoctorId() { return doctorId; }
    public void setDoctorId(String doctorId) { this.doctorId = doctorId; }

    public String getSlotId() { return slotId; }
    public void setSlotId(String slotId) { this.slotId = slotId; }
}
