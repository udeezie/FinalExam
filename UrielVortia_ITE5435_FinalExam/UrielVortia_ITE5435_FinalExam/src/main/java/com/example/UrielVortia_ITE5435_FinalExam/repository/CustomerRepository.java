package com.example.UrielVortia_ITE5435_FinalExam.repository;

import com.example.UrielVortia_ITE5435_FinalExam.model.Customer;
import org.springframework.data.mongodb.repository.MongoRepository;

public interface CustomerRepository extends MongoRepository<Customer, String> {
}
