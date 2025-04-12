package com.example.UrielVortia_ITE5435_FinalExam.controller;

import com.example.UrielVortia_ITE5435_FinalExam.model.*;
import com.example.UrielVortia_ITE5435_FinalExam.repository.*;
import com.fasterxml.jackson.databind.ObjectMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;

@Controller
public class CustomerController {

    @Autowired private CustomerRepository customerRepository;
    @Autowired private ReservationRepository reservationRepository;
    @Autowired private PaymentRepository paymentRepository;
    @Autowired private ObjectMapper objectMapper;

    @GetMapping("/")
    public String showForm(Model model) {
        model.addAttribute("form", new FormDTO());
        return "customer-form";
    }

    @PostMapping("/submit")
    public String handleSubmit(@ModelAttribute("form") FormDTO form, Model model) throws Exception {
        String json = objectMapper.writeValueAsString(form);
        System.out.println("JSON: " + json);

        Reservation reservation = new Reservation();
        reservation.setId((int) (Math.random() * 10000));
        reservation.setDetails("Passengers: " + form.getNumberOfPassengers() + ", Class: " + form.getTravelClass());
        reservation.setTicketNumber("TKT" + System.nanoTime());
        reservation.setDate(form.getDateOfDeparture() + " " + form.getTime());
        reservationRepository.save(reservation);

        Customer customer = new Customer();
        customer.setDetails(form.getFirstName() + " " + form.getLastName());
        customer.setReservation(String.valueOf(reservation.getId()));
        customer.setAddress(form.getPhoneNumber());
        customerRepository.save(customer);

        Payment payment = new Payment();
        payment.setId(reservation.getId());
        payment.setAmount(form.getNumberOfPassengers() * 100);
        payment.setDate(form.getDateOfDeparture());
        paymentRepository.save(payment);

        model.addAttribute("successMessage", "Customer details successfully saved!");
        return "confirmation";
    }
}
