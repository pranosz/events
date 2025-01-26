package com.m_running.events.service;

import com.m_running.events.model.Event;
import com.m_running.events.repo.EventRepo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.web.multipart.MultipartFile;

import java.io.IOException;
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

    public Event addEvent(Event event, MultipartFile image) throws IOException {
        event.setImageName(image.getOriginalFilename());
        event.setImageType(image.getContentType());
        event.setImageData(image.getBytes());

        return eventRepo.save(event);
    }
}
