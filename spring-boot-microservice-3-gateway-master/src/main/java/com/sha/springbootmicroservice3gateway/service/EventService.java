package com.sha.springbootmicroservice3gateway.service;

import com.google.gson.JsonElement;
import com.sha.springbootmicroservice3gateway.request.IEventServiceRequest;
import com.sha.springbootmicroservice3gateway.util.RetrofitUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

/**
 * @author sa
 * @date 18.04.2021
 * @time 14:27
 */
@Service
public class EventService implements IEventService
{
    @Autowired
    private IEventServiceRequest eventServiceRequest;

    @Override
    public JsonElement saveEvent(JsonElement event)
    {
        return RetrofitUtils.executeInBlock(eventServiceRequest.saveEvent(event));
    }

    @Override
    public void deleteEvent(Long transactionId)
    {
        RetrofitUtils.executeInBlock(eventServiceRequest.deleteEvent(transactionId));
    }

    @Override
    public List<JsonElement> getAllEventsOfUser(Long userId)
    {
        return RetrofitUtils.executeInBlock(eventServiceRequest.getAllEventsOfUser(userId));
    }
}
