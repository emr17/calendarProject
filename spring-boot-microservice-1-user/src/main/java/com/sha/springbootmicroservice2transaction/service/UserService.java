package com.sha.springbootmicroservice2transaction.service;


import com.sha.springbootmicroservice2transaction.model.User;
import com.sha.springbootmicroservice2transaction.repository.IUserRepository;
import com.sha.springbootmicroservice2transaction.utilites.results.DataResult;
import com.sha.springbootmicroservice2transaction.utilites.results.SuccessDataResult;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.time.LocalDateTime;
import java.util.List;
import java.util.Optional;

/**
 * @author sa
 * @date 17.04.2021
 * @time 12:24
 */
@Service
public class UserService implements IUserService
{
    @Autowired
    private IUserRepository userRepository;

    @Override
    public User saveUser(User user)
    {

        user.setCreateTime(LocalDateTime.now());
        return userRepository.save(user);
    }



    @Override
    public List<User> findAllUsers()
    {
        return this.userRepository.findAll();
    }

    @Override
    public User findByEmail(String email) {
        return this.userRepository.findByEmail(email);
    }
}

