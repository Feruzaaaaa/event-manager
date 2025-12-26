package com.example.eventmanager.controller;

import com.example.eventmanager.dto.EventRequestDTO;
import com.example.eventmanager.model.Event;
import com.example.eventmanager.service.EventService;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/events")
public class EventController {

    private final EventService service;

    public EventController(EventService service) {
        this.service = service;
    }

    @PostMapping
    public Event create(@RequestBody EventRequestDTO dto) {
        return service.create(dto, 1L);
    }

    @GetMapping
    public List<Event> getAll() {
        return service.getAll();
    }

    @PostMapping("/{id}/register")
    public String register(@PathVariable Long id, @RequestParam Long userId) {
        service.register(id, userId);
        return "Registered";
    }
}
