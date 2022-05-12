package com.sha.springbootmicroservice2transaction.service;


import com.sha.springbootmicroservice2transaction.model.User;
import com.sha.springbootmicroservice2transaction.utilites.results.DataResult;

import java.util.List;
import java.util.Optional;

/**
 * @author sa
 * @date 17.04.2021
 * @time 12:23
 */
public interface IUserService
{
    public User saveUser(User user);

    public User findByEmail(String email);

    public List<User> findAllUsers();
}
