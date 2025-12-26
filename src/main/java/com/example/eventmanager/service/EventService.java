package com.example.eventmanager.service;

import com.example.eventmanager.dto.EventRequestDTO;
import com.example.eventmanager.model.Event;
import java.util.List;

public interface EventService {
    Event create(EventRequestDTO dto, Long organizerId);
    List<Event> getAll();
    void register(Long eventId, Long userId);
}
