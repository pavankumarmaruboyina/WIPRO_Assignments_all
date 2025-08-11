package com.model;


//AppointmentService.java
import java.time.LocalDate;

public class AppointmentService {
 private DoctorRepository doctorRepository;

 // Spring will inject the repository
 public void setDoctorRepository(DoctorRepository doctorRepository) {
     this.doctorRepository = doctorRepository;
 }

 public String book(String doctorId, String dateStr) {
     LocalDate date = LocalDate.parse(dateStr);
     if (doctorRepository.isAvailable(doctorId, date)) {
         doctorRepository.bookDate(doctorId, date);
         return "Appointment confirmed";
     } else {
         return "Doctor not available";
     }
 }
}
