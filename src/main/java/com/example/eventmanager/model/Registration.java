package com.example.eventmanager.model;

import jakarta.persistence.*;

@Entity
public class Registration {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @ManyToOne
    private User participant;

    @ManyToOne
    private Event event;

    public Long getId() { return id; }
    public User getParticipant() { return participant; }
    public Event getEvent() { return event; }

    public void setId(Long id) { this.id = id; }
    public void setParticipant(User participant) { this.participant = participant; }
    public void setEvent(Event event) { this.event = event; }
}
