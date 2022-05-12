package com.sha.springbootmicroservice2transaction.model;

import lombok.Data;

import javax.persistence.*;
import java.time.LocalDateTime;

/**
 * @author sa
 * @date 17.04.2021
 * @time 11:07
 */
@Data
@Entity
@Table(name = "users")//user is a reserved word and it's usually not a good idea use reserved words for identifiers
public class User
{
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @Column(name = "email", unique = true, nullable = false, length = 100)
    private String email;


    @Column(name = "password", nullable = false)
    private String password;

    @Column(name = "name", nullable = false)
    private String name;

    @Column(name = "create_time")
    private LocalDateTime createTime;
}
