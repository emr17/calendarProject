package com.sha.springbootmicroservice3gateway.request;

import com.google.gson.JsonElement;
import retrofit2.Call;
import retrofit2.http.*;

import java.util.List;


public interface IEventServiceRequest
{
    @POST("/api/calendar")
    Call<JsonElement> saveEvent(@Body JsonElement requestBody);

    @DELETE("/api/calendar/{eventId}")
    Call<Void> deleteEvent(@Path("eventId") Long eventId);

    @GET("/api/calendar/{eventId}")
    Call<List<JsonElement>> getAllEventsOfUser(@Path("eventId") Long userId);
}
