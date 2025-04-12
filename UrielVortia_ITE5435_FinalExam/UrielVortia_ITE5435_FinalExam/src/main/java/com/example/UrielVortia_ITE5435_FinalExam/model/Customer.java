package com.example.UrielVortia_ITE5435_FinalExam.model;

import org.springframework.data.annotation.Id;
import org.springframework.data.mongodb.core.mapping.Document;

@Document(collection = "customers")
public class Customer {

    @Id
    private String id;
    private String address;
    private String reservation;
    private String details;

    public void add(String address, String reservation, String details) {
        this.address = address;
        this.reservation = reservation;
        this.details = details;
    }

    public void update(String address, String reservation, String details) {
        this.address = address;
        this.reservation = reservation;
        this.details = details;
    }

    public String getId() {
        return id;
    }

    public String getAddress() {
        return address;
    }

    public void setAddress(String address) {
        this.address = address;
    }

    public String getReservation() {
        return reservation;
    }

    public void setReservation(String reservation) {
        this.reservation = reservation;
    }

    public String getDetails() {
        return details;
    }

    public void setDetails(String details) {
        this.details = details;
    }
}
