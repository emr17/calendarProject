package com.sha.springbootmicroservice2transaction.repository;


import com.sha.springbootmicroservice2transaction.model.User;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.Optional;

/**
 * @author sa
 * @date 17.04.2021
 * @time 11:23
 */
public interface IUserRepository extends JpaRepository<User, Long>
{
    User findByEmail(String email);

}
