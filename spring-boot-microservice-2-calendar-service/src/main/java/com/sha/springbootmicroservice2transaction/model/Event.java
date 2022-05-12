package com.sha.springbootmicroservice2transaction.model;

import lombok.Data;

import javax.persistence.*;


@Data
@Entity
@Table(name = "events")
public class Event
{
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @Column(name = "user_id", nullable = false)
    private Long userId;

    @Column(name = "start_date", nullable = true)
    private String startDate;

    @Column(name = "end_date", nullable = true)
    private String endDate;

    @Column(name = "title", nullable = true)
    private String title;

    @Column(name = "description", nullable = true)
    private String description;

    @Column(name = "all_day", nullable = true)
    private boolean allDay;

    @Column(name = "free", nullable = true)
    private boolean free;

    @Column(name = "color", nullable = true)
    private String color;

}
