package com.m_running.events.model;

import com.fasterxml.jackson.annotation.JsonProperty;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import java.util.Date;

@Entity
@Data
@NoArgsConstructor
@AllArgsConstructor
public class Event {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int id;

    @JsonProperty
    private String name;

    @JsonProperty
    private String description;

    @JsonProperty
    private double distance;

    @JsonProperty
    private int altitude;

    @JsonProperty
    private int itra;

    @JsonProperty
    private int price;

    @JsonProperty
    private Date date;

    @JsonProperty
    private String location;
}
