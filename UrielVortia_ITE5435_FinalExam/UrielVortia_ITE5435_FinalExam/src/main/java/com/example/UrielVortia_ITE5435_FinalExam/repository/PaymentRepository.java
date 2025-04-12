package com.example.UrielVortia_ITE5435_FinalExam.repository;

import com.example.UrielVortia_ITE5435_FinalExam.model.Payment;
import org.springframework.data.mongodb.repository.MongoRepository;

public interface PaymentRepository extends MongoRepository<Payment, Integer> {
}
