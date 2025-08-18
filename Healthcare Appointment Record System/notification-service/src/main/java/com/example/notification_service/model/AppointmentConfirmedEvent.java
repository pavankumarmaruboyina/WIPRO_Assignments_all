package com.example.notification_service.model;

public class AppointmentConfirmedEvent {

    private String appointmentId;
    private String patientId;
    private String doctorId;
    private String slotId;

    public AppointmentConfirmedEvent() {
    }

    public String getAppointmentId() {
        return appointmentId;
    }
    public void setAppointmentId(String appointmentId) {
        this.appointmentId = appointmentId;
    }

    public String getPatientId() {
        return patientId;
    }
    public void setPatientId(String patientId) {
        this.patientId = patientId;
    }

    public String getDoctorId() {
        return doctorId;
    }
    public void setDoctorId(String doctorId) {
        this.doctorId = doctorId;
    }

    public String getSlotId() {
        return slotId;
    }
    public void setSlotId(String slotId) {
        this.slotId = slotId;
    }

    @Override
    public String toString() {
        return "AppointmentConfirmedEvent{" +
                "appointmentId='" + appointmentId + '\'' +
                ", patientId='" + patientId + '\'' +
                ", doctorId='" + doctorId + '\'' +
                ", slotId='" + slotId + '\'' +
                '}';
    }
}
