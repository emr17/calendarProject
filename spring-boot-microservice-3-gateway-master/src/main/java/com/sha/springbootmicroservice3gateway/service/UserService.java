package com.sha.springbootmicroservice3gateway.service;

import com.google.gson.JsonElement;
import com.sha.springbootmicroservice3gateway.request.IUserServiceRequest;
import com.sha.springbootmicroservice3gateway.util.RetrofitUtils;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;


@Slf4j
@Service
public class UserService implements IUserService
{
    //retrofitconfigurationda oluşturduğumuz bean nesnesi productServiceRequest
    @Autowired
    private IUserServiceRequest userServiceRequest;

    @Override
    public JsonElement add(JsonElement requestBody)
    {
        return RetrofitUtils.executeInBlock(userServiceRequest.add(requestBody));
    }

    @Override
    public JsonElement findByEmail(String email)
    {
       return RetrofitUtils.executeInBlock(userServiceRequest.findByEmail(email));
    }

    @Override
    public List<JsonElement> findAllUsers()
    {
        return RetrofitUtils.executeInBlock(userServiceRequest.findAllUsers());
    }
}
