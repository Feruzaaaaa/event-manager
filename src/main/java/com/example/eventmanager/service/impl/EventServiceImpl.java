package com.example.eventmanager.service.impl;

import com.example.eventmanager.dto.EventRequestDTO;
import com.example.eventmanager.factory.EventFactory;
import com.example.eventmanager.model.*;
import com.example.eventmanager.repository.*;
import com.example.eventmanager.service.EventService;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class EventServiceImpl implements EventService {

    private final EventRepository eventRepo;
    private final UserRepository userRepo;
    private final RegistrationRepository regRepo;

    public EventServiceImpl(EventRepository e, UserRepository u, RegistrationRepository r) {
        this.eventRepo = e;
        this.userRepo = u;
        this.regRepo = r;
    }

    public Event create(EventRequestDTO dto, Long organizerId) {
        User organizer = userRepo.findById(organizerId).orElseThrow();
        Event event = EventFactory.create(dto, organizer);
        return eventRepo.save(event);
    }

    public List<Event> getAll() {
        return eventRepo.findAll();
    }

    public void register(Long eventId, Long userId) {
        Event event = eventRepo.findById(eventId).orElseThrow();
        User user = userRepo.findById(userId).orElseThrow();

        if (regRepo.countByEvent(event) >= event.getCapacity()) {
            throw new RuntimeException("Event is full");
        }

        Registration r = new Registration();
        r.setEvent(event);
        r.setParticipant(user);
        regRepo.save(r);
    }
}
