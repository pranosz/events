package com.m_running.events.service;

import com.m_running.events.model.Event;
import com.m_running.events.repo.EventRepo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class EventService {

    @Autowired
    private EventRepo eventRepo;

    public List<Event> getAllEvents() {
        return eventRepo.findAll();
    }

    public Event getEventById(int id) {
        return eventRepo.findById(id).orElse(new Event(-1));
    }
}
