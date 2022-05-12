package com.sha.springbootmicroservice3gateway.request;

import com.google.gson.JsonElement;
import retrofit2.Call;
import retrofit2.http.*;

import java.util.List;


public interface IUserServiceRequest
{
    @POST("/api/users/add")
    Call<JsonElement> add(@Body JsonElement requestBody);



    @GET("/api/users/getall")
    Call<List<JsonElement>> findAllUsers();

    @GET("/api/users/findbyemail")
    Call<JsonElement> findByEmail(@Query("email") String email);
}
