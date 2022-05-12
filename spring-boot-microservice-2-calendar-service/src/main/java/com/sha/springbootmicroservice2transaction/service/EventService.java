package com.sha.springbootmicroservice2transaction.service;

import com.sha.springbootmicroservice2transaction.model.Event;
import com.sha.springbootmicroservice2transaction.repository.IEventRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.time.LocalDateTime;
import java.util.List;


@Service
public class EventService implements IEventService
{
    @Autowired
    private IEventRepository eventRepository;

    @Override
    public Event saveEvent(Event event)
    {

        return eventRepository.save(event);
    }

    @Override
    public void deleteEvent(Long eventId)
    {
        eventRepository.deleteById(eventId);
    }

    @Override
    public List<Event> findAllEventsOfUser(Long userId)
    {
        return eventRepository.findAllByUserId(userId);
    }
}
