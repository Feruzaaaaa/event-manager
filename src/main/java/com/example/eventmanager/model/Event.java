package com.example.eventmanager.model;

import jakarta.persistence.*;
import java.time.LocalDateTime;

@Entity
public class Event {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    private String title;
    private String location;
    private LocalDateTime date;
    private int capacity;

    @ManyToOne
    private User organizer;

    public Long getId() { return id; }
    public String getTitle() { return title; }
    public String getLocation() { return location; }
    public LocalDateTime getDate() { return date; }
    public int getCapacity() { return capacity; }
    public User getOrganizer() { return organizer; }

    public void setId(Long id) { this.id = id; }
    public void setTitle(String title) { this.title = title; }
    public void setLocation(String location) { this.location = location; }
    public void setDate(LocalDateTime date) { this.date = date; }
    public void setCapacity(int capacity) { this.capacity = capacity; }
    public void setOrganizer(User organizer) { this.organizer = organizer; }
}
