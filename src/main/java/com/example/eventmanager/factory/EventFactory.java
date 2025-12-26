package com.example.eventmanager.factory;

import com.example.eventmanager.dto.EventRequestDTO;
import com.example.eventmanager.model.Event;
import com.example.eventmanager.model.User;

public class EventFactory {

    public static Event create(EventRequestDTO dto, User organizer) {
        Event event = new Event();
        event.setTitle(dto.title);
        event.setLocation(dto.location);
        event.setDate(dto.date);
        event.setCapacity(dto.capacity);
        event.setOrganizer(organizer);
        return event;
    }
}
