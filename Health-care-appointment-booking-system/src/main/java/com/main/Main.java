package com.main;
import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

import com.model.AppointmentService;

public class Main {
    public static void main(String[] args) {
        ApplicationContext ctx = new ClassPathXmlApplicationContext("beans.xml");
        
        AppointmentService appointmentService = (AppointmentService) ctx.getBean("appointmentService");

//        String result = appointmentService.book("DOC101", "2025-04-10");
        String result =appointmentService.book("DOC101", "2025-04-10");
        
        
        System.out.println(result);  // "Appointment confirmed" or "Doctor not available"
        
        String result1 =appointmentService.book("DOC101", "2025-04-10");
        
        
        System.out.println(result1);  // "Appointment confirmed" or "Doctor not available"
        
    }
}