package com.sha.springbootmicroservice3gateway.service;

import com.google.gson.JsonElement;

import java.util.List;

/**
 * @author sa
 * @date 18.04.2021
 * @time 14:08
 */
public interface IUserService
{
    JsonElement add(JsonElement requestBody);


    JsonElement findByEmail(String email);

    List<JsonElement> findAllUsers();
}
