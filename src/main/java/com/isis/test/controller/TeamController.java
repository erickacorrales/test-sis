package com.isis.test.controller;

import com.isis.test.model.Team;
import com.isis.test.repository.TeamRepository;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;
import com.isis.test.service.TeamService;

import java.util.List;


/**
 * Created by erickacorrales on 17/6/17.
 */
@RestController
@RequestMapping("api")
public class TeamController {


    @Autowired
    private TeamService teamService;

    private static final Logger LOGGER = LoggerFactory.getLogger(TeamController.class);


    @RequestMapping(value = "teams", method = RequestMethod.GET)
    public List<Team> list(final String sort){
        return this.teamService.getList(sort);
    }

    @RequestMapping(value = "teams", method = RequestMethod.POST)
    public Team create(@RequestBody Team team){
        return this.teamService.create(team);
    }

    @RequestMapping(value = "teams/{id}", method = RequestMethod.GET)
    public Team get(@PathVariable Long id){
        return  this.teamService.getDetail(id);
    }

}
