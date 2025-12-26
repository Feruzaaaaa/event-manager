package com.example.eventmanager.repository;

import com.example.eventmanager.model.Event;
import com.example.eventmanager.model.Registration;
import org.springframework.data.jpa.repository.JpaRepository;

public interface RegistrationRepository extends JpaRepository<Registration, Long> {
    long countByEvent(Event event);
}
