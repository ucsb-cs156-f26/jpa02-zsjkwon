package edu.ucsb.cs156.spring.hello;

import static org.junit.jupiter.api.Assertions.assertEquals;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

public class TeamTest {

    Team team;

    @BeforeEach
    public void setup() {
        team = new Team("test-team");    
    }

    @Test
    public void getName_returns_correct_name() {
       assert(team.getName().equals("test-team"));
    }

    @Test
    public void toString_returns_correct_string() {
        assertEquals("Team(name=test-team, members=[])", team.toString());
    }

    @Test
    public void equals_returns_correct_value() {
        // t1, t2: same name, different members
        // t1, t3: different name, same members
        // t1, t4: different name, different members
        // t1, t5: same name, same members

        Team t1 = new Team("team A");
        t1.addMember("Superman");
        t1.addMember("Batman");

        Team t2 = new Team("team A");
        t2.addMember("Flash");

        Team t3 = new Team("team B");
        t3.addMember("Superman");
        t3.addMember("Batman");

        Team t4 = new Team("team B");
        t4.addMember("Flash");

        Team t5 = new Team("team A");
        t5.addMember("Superman");
        t5.addMember("Batman");


        // Case 1: same object
        assertEquals(t1, t1);

        // Case 2: different class
        assert !(t1.equals("fake team"));

        // Case 3: Team comparisons
        assert !t1.equals(t2);
        assert !t1.equals(t3);
        assert !t1.equals(t4);
        assertEquals(t1, t5);
    }

    @Test
    public void hashCode_returns_correct_value() {
        // Testing hashcode values being equivalent for equivalent objects
        Team t1 = new Team();
        t1.setName("foo");
        t1.addMember("bar");
        Team t2 = new Team();
        t2.setName("foo");
        t2.addMember("bar");
        assertEquals(t1.hashCode(), t2.hashCode());

        Team t = new Team();
        int result = t.hashCode();
        int expectedResult = 1;
        assertEquals(expectedResult, result);

    }
}
