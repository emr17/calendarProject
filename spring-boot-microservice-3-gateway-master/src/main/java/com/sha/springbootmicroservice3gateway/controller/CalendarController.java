package com.sha.springbootmicroservice3gateway.controller;

import com.google.gson.JsonElement;
import com.sha.springbootmicroservice3gateway.service.IEventService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@CrossOrigin
@RestController
@RequestMapping("gateway/calendar")
public class CalendarController
{
    @Autowired
    private IEventService eventService;

    @PostMapping
    public ResponseEntity<?> saveEvent(@RequestBody JsonElement event)
    {
        return ResponseEntity.ok(eventService.saveEvent(event));
    }

    @DeleteMapping("{eventId}")
    public ResponseEntity<?> deleteEvent(@PathVariable Long eventId)
    {
        eventService.deleteEvent(eventId);

        return new ResponseEntity<>(HttpStatus.OK);
    }

    @GetMapping("{userId}")
    public ResponseEntity<?> getAllEventsOfUser(@PathVariable Long userId)
    {//AuthenticationPrincipal doğrulanan kullanıcı olayı
        return ResponseEntity.ok(eventService.getAllEventsOfUser(userId));
    }
}
