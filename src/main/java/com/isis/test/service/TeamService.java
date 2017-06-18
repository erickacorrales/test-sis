package com.isis.test.service;

import com.isis.test.model.Team;
import com.isis.test.repository.TeamRepository;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

/**
 * Created by erickacorrales on 17/6/17.
 */
@Service
public class TeamService {

    @Autowired
    private TeamRepository teamRepository;

    private static String ORDER_TYPE_STADIUM_CAPACITY = "stadiumCapacity";

    private static final Logger LOGGER = LoggerFactory.getLogger(TeamService.class);

    public List<Team> getList(String sort){

        if (sort != null && ORDER_TYPE_STADIUM_CAPACITY.equals(sort)) {
            LOGGER.debug("Retriever teams with " + ORDER_TYPE_STADIUM_CAPACITY +" Order");
            return teamRepository.findAllByOrderByStadiumCapacityAsc();
        }

        return teamRepository.findAll();
    }

    public Team create(Team team){
        LOGGER.debug("Save team");
        return teamRepository.saveAndFlush(team);
    }

    public Team getDetail(Long id){
        LOGGER.debug("Detail of one team", id);
        return this.teamRepository.findOne(id);
    }


}
