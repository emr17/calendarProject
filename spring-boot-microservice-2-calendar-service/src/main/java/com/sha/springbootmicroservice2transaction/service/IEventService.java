package com.sha.springbootmicroservice2transaction.service;

import com.sha.springbootmicroservice2transaction.model.Event;

import java.util.List;


public interface IEventService
{
    Event saveEvent(Event event);

    void deleteEvent(Long transactionId);

    List<Event> findAllEventsOfUser(Long userId);
}
