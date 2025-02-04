package com.m_running.events.controller;

import com.fasterxml.jackson.databind.ObjectMapper;
import com.m_running.events.model.Event;
import com.m_running.events.service.EventService;
import org.antlr.v4.runtime.misc.NotNull;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.multipart.MultipartFile;

import java.io.IOException;
import java.util.List;

@RestController
@RequestMapping("/api")
@CrossOrigin
public class EventsController {

    @Autowired
    private EventService eventService;
    private final ObjectMapper objectMapper;

    public EventsController(ObjectMapper objectMapper) {
        this.objectMapper = objectMapper;
    }

    @GetMapping("/events")
    public ResponseEntity<List<Event>> getEvents() {
        return new ResponseEntity<>(eventService.getAllEvents(), HttpStatus.OK);
    }

    @GetMapping("/event/{id}")
    public ResponseEntity<Event> getEventById(@PathVariable int id) {
        Event event = eventService.getEventById(id);
        if(event.getId() > 0){
            return new ResponseEntity<>(event, HttpStatus.OK);
        } else {
            return new ResponseEntity<>(HttpStatus.NOT_FOUND);
        }
    }

    @GetMapping("event/{eventId}/image")
    public ResponseEntity<byte[]> getImageBuEventId(@PathVariable int eventId) {
        Event event = eventService.getEventById(eventId);
        if(event.getId() > 0){
            return  new ResponseEntity<>(event.getImageData(), HttpStatus.OK);
        } else {
            return new ResponseEntity<>(HttpStatus.NOT_FOUND);
        }
    };

    @PostMapping("/event")
    public ResponseEntity<?> addEvent(
            @RequestPart("event") String eventJson,
            @RequestPart("image") @NotNull MultipartFile image
    ) {
        Event savedEvent = null;
        try {
            Event event = objectMapper.readValue(eventJson, Event.class);
            savedEvent = eventService.addOrUpdateEvent(event, image);
            return new ResponseEntity<>(savedEvent, HttpStatus.CREATED);
        } catch (IOException e) {
            return new ResponseEntity<>(e.getMessage(), HttpStatus.INTERNAL_SERVER_ERROR);
        }
    };

    @PutMapping("/event/{id}")
    public ResponseEntity<String> updateEvent(
            @PathVariable int id,
            @RequestPart("event") String eventJson,
            @RequestPart("image") @NotNull MultipartFile image)
    {
        Event updatedEvent = null;
        try {
            Event event = objectMapper.readValue(eventJson, Event.class);
            updatedEvent = eventService.addOrUpdateEvent(event, image);
            return new ResponseEntity<>("Updated", HttpStatus.OK);
        } catch (IOException e) {
            return new ResponseEntity<>(e.getMessage(), HttpStatus.INTERNAL_SERVER_ERROR);
        }
    };

    @DeleteMapping("/event/{id}")
    public ResponseEntity<String> deleteEvent(@PathVariable int id) {
        Event event = eventService.getEventById(id);
        if(event != null){
            eventService.deleteEvent(id);
            return new ResponseEntity<>("Deleted", HttpStatus.OK);
        }
        return new ResponseEntity<>(HttpStatus.NOT_FOUND);
    }

    @GetMapping("/events/search")
    public  ResponseEntity<List<Event>> searchEvents(@RequestParam String keyword) {
        List<Event> events = eventService.searchEvent(keyword);
        System.out.println("Searching with " + keyword);
        return new ResponseEntity<>(events, HttpStatus.OK);
    }
}
