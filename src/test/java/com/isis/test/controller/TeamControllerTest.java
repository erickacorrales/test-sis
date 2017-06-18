package com.isis.test.controller;


import com.isis.test.model.Team;
import com.isis.test.repository.TeamRepository;
import org.junit.Before;
import org.junit.Test;
import org.junit.runner.RunWith;

import org.mockito.Mockito;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.http.MediaType;
import org.springframework.test.context.junit4.SpringRunner;
import org.springframework.test.web.servlet.MockMvc;
import org.springframework.test.web.servlet.setup.MockMvcBuilders;
import org.springframework.web.context.WebApplicationContext;

import java.nio.charset.Charset;
import java.sql.Date;

import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.*;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.*;
import static org.hamcrest.Matchers.*;



/**
 * Created by erickacorrales on 17/6/17.
 */
@RunWith(SpringRunner.class)
@SpringBootTest(webEnvironment = SpringBootTest.WebEnvironment.RANDOM_PORT)

public class TeamControllerTest {

    @Autowired
    private WebApplicationContext context;

    private MockMvc mvc;

    private MediaType contentType = new MediaType(MediaType.APPLICATION_JSON.getType(),
            MediaType.APPLICATION_JSON.getSubtype(),
            Charset.forName("utf8"));

    @Autowired
    private TeamRepository teamRepository;

    private Team team;

    @Before
    public void setup() {
        this.mvc = MockMvcBuilders
                .webAppContextSetup(context)
                .build();

        this.team = teamRepository.save(new Team("Valencia", "Valencia","Chan", 20000,"Champions", 30, Mockito.mock(Date.class)));
    }


    @Test
    public void readTeam() throws Exception {
        this.mvc.perform(get("/api/teams/4"))
                .andExpect(status().isOk())
                .andExpect(content().contentType(contentType))
                .andExpect(jsonPath("$.id", is(this.team.getId().intValue())))
                .andExpect(jsonPath("$.name", is(this.team.getName())))
                .andExpect(jsonPath("$.city", is(this.team.getCity())));
    }


}
