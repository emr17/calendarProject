package com.sha.springbootmicroservice2transaction.repository;

import com.sha.springbootmicroservice2transaction.model.Event;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;


public interface IEventRepository extends JpaRepository<Event, Long>
{
    List<Event> findAllByUserId(Long userId);
}
