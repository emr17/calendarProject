package com.sha.springbootmicroservice3gateway.service;

import com.google.gson.JsonElement;

import java.util.List;


public interface IEventService
{
    JsonElement saveEvent(JsonElement event);

    void deleteEvent(Long eventId);

    List<JsonElement> getAllEventsOfUser(Long userId);
}
