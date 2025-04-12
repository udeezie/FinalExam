package com.example.UrielVortia_ITE5435_FinalExam.controller;

import com.example.UrielVortia_ITE5435_FinalExam.model.FormDTO;
import com.fasterxml.jackson.databind.ObjectMapper;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/api")
public class ApiController {

    private final ObjectMapper objectMapper;

    public ApiController(ObjectMapper objectMapper) {
        this.objectMapper = objectMapper;
    }

    @GetMapping("/test")
    public String testApi() {
        return "API is working";
    }

    @PostMapping("/reservation")
    public String receiveReservation(@RequestBody FormDTO form) throws Exception {
        return "Received reservation data: " + objectMapper.writeValueAsString(form);
    }

    @PutMapping("/reservation/{id}")
    public String updateReservation(@PathVariable int id, @RequestBody FormDTO form) {
        return "Updated reservation ID " + id + " with " + form.getNumberOfPassengers() + " passengers.";
    }
}
