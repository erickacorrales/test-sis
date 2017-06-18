package com.isis.test.model;

import org.junit.Before;
import org.junit.Rule;
import org.junit.Test;
import org.junit.rules.ExpectedException;
import org.junit.runner.RunWith;
import org.mockito.Mockito;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.orm.jpa.DataJpaTest;
import org.springframework.boot.test.autoconfigure.orm.jpa.TestEntityManager;
import org.springframework.test.context.junit4.SpringRunner;


import java.sql.Date;

import static org.assertj.core.api.Assertions.assertThat;

/**
 * Created by erickacorrales on 17/6/17.
 */
@RunWith(SpringRunner.class)
@DataJpaTest
public class TeamEntityTest {

    @Rule
    public ExpectedException thrown = ExpectedException.none();

    @Autowired
    private TestEntityManager entityManager;

    public Date dateOfCreation;

    @Before
    public void setUp() {
        dateOfCreation = Mockito.mock(Date.class);
    }

    @Test
    public void saveShouldPersistData() throws Exception {
        Team teamTest = this.entityManager.persistFlushFind(this.buildObjectTeam());
        assertThat(teamTest.getName()).isEqualTo("Name");
        assertThat(teamTest.getCity()).isEqualTo("London");
    }

    private Team buildObjectTeam(){
        return new Team("Name", "London","Jack", 1500,"Test", 30, dateOfCreation);
    }
}
