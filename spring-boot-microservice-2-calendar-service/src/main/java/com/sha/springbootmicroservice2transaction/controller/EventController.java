package com.sha.springbootmicroservice2transaction.controller;

import com.sha.springbootmicroservice2transaction.model.Event;
import com.sha.springbootmicroservice2transaction.service.IEventService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@CrossOrigin
@RestController
@RequestMapping("api/calendar")//pre-path
public class EventController
{
    @Autowired
    private IEventService eventService;

    @PostMapping
    public ResponseEntity<?> saveEvent(@RequestBody Event event)
    {
        return new ResponseEntity<>(eventService.saveEvent(event), HttpStatus.CREATED);
    }

    @DeleteMapping("{eventId}")
    public ResponseEntity<?> deleteEvent(@PathVariable Long eventId)
    {
        eventService.deleteEvent(eventId);
        return new ResponseEntity<>(HttpStatus.OK);
    }

    @GetMapping("{userId}")
    public ResponseEntity<?> getAllEventsOfUser(@PathVariable Long userId)
    {
        return ResponseEntity.ok(eventService.findAllEventsOfUser(userId));
    }
}
