package com.isis.test.repository;

import com.isis.test.model.Team;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;

/**
 * Created by erickacorrales on 17/6/17.
 */
public interface TeamRepository extends JpaRepository<Team, Long> {
    public List<Team> findAllByOrderByStadiumCapacityAsc();
}
