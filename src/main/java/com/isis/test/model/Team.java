package com.isis.test.model;
import lombok.Data;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import java.sql.Date;


/**
 * Created by erickacorrales on 17/6/17.
 */
@Entity
@Data
public class Team {

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Long id;

    private String name;
    private String city;
    private String owner;
    private int stadiumCapacity;
    private String competition;
    private int numberOfPlayers;
    private Date dateOn;

    private Team() {
    }

    public Team(String name, String city, String owner, int stadiumCapacity, String competition, int numberOfPlayers, Date dateOn) {
        this.name = name;
        this.city = city;
        this.owner = owner;
        this.stadiumCapacity = stadiumCapacity;
        this.competition = competition;
        this.numberOfPlayers = numberOfPlayers;
        this.dateOn = dateOn;
    }


}
