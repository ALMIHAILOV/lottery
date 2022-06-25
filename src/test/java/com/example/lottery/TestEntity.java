package com.example.lottery;

import com.example.lottery.model.Participant;
import com.example.lottery.model.Winner;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;
import org.springframework.boot.test.context.SpringBootTest;

@SpringBootTest
public class TestEntity {

    @Test
    public void participantTest() {
        Participant participant = new Participant();
        String name = "Name";
        String city = "City";
        int age = 50;

        participant.setName(name);
        participant.setCity(city);
        participant.setAge(age);

        Assertions.assertEquals(participant.getName(), name);
        Assertions.assertEquals(participant.getCity(), city);
        Assertions.assertEquals(participant.getAge(), age);
    }

    @Test
    public void winnerTest() {
        Winner winner = new Winner();
        String name = "Name";
        String city = "City";
        int age = 50;
        int amount = 500;

        winner.setName(name);
        winner.setCity(city);
        winner.setAge(age);
        winner.setAmount(amount);

        Assertions.assertEquals(winner.getName(), name);
        Assertions.assertEquals(winner.getCity(), city);
        Assertions.assertEquals(winner.getAge(), age);
        Assertions.assertEquals(winner.getAmount(), amount);
    }
}
