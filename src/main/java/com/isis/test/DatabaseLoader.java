package com.isis.test;

import com.isis.test.model.Team;
import com.isis.test.repository.TeamRepository;
import com.isis.test.service.TeamService;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.stereotype.Component;

import java.sql.Date;

/**
 * Created by erickacorrales on 17/6/17.
 */
@Component
public class DatabaseLoader  implements CommandLineRunner {

    private final TeamRepository repository;

    @Autowired
    public DatabaseLoader(TeamRepository repository) {
        this.repository = repository;
    }

    private static final Logger LOGGER = LoggerFactory.getLogger(DatabaseLoader.class);

    @Override
    public void run(String... strings) throws Exception {

        LOGGER.info("Creating some data for Demo");

        java.util.Date dateTest = Date.valueOf("2016-05-15");

        this.repository.save(new Team("RM", "Madrid", "NoName", 36000,
                "XX", 30, new Date(dateTest.getTime())));

        this.repository.save(new Team("BCN", "Barcelona", "NoName", 50000,
                "XX", 30, new Date(dateTest.getTime())));

        this.repository.save(new Team("AM", "Madrid", "NoName", 22000,
                "XX", 30, new Date(dateTest.getTime())));

        LOGGER.info("Finish creating some data Demo");
    }
}
