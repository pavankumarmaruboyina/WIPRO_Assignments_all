package com.main;

import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;
import com.model.TicketService;

public class Main {
    public static void main(String[] args) {
        ApplicationContext context = new ClassPathXmlApplicationContext("airline-context.xml");
        TicketService ticketService = context.getBean("ticketService", TicketService.class);

        System.out.println(ticketService.confirmBooking("FL123", "USER456")); // Booking confirmed
        System.out.println(ticketService.confirmBooking("FL123", "USER789")); // Booking confirmed
        System.out.println(ticketService.confirmBooking("FL123", "USER000")); // Flight FL123 is full

        System.out.println(ticketService.confirmBooking("FL456", "USER123")); // Flight FL456 is full
    }
}