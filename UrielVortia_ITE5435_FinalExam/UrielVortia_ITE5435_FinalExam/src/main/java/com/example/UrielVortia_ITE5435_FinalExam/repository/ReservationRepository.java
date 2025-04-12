package com.example.UrielVortia_ITE5435_FinalExam.repository;

import com.example.UrielVortia_ITE5435_FinalExam.model.Reservation;
import org.springframework.data.mongodb.repository.MongoRepository;

public interface ReservationRepository extends MongoRepository<Reservation, Integer> {
}
