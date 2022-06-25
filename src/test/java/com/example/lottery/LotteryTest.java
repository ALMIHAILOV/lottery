package com.example.lottery;

import com.example.lottery.data.ParticipantRepository;
import com.example.lottery.exception.TooFewMembersException;
import com.example.lottery.model.Participant;
import com.example.lottery.service.Lottery;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.RepeatedTest;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.annotation.Rollback;
import org.springframework.transaction.annotation.Transactional;



@SpringBootTest
public class LotteryTest {
    @Autowired
    private ParticipantRepository participantRepository;

    @Autowired
    private Lottery lottery;

    @RepeatedTest(value = 2)
    @Transactional
    @Rollback
    public void lotteryStartTest1() {
        Participant participant = new Participant();
        participant.setAge(50);
        participant.setCity("City");
        participant.setName("Name");

        participantRepository.save(participant);

        Participant participant1 = new Participant();
        participant1.setAge(60);
        participant1.setCity("City1");
        participant1.setName("Name1");

        participantRepository.save(participant1);

        try{
            lottery.start();
        }catch (TooFewMembersException e) {
            Assertions.assertEquals("Too few members", e.getMessage());
        }

    }

    @RepeatedTest(value = 2)
    @Transactional
    @Rollback
    public void lotteryStartTest2() {
        Participant participant = new Participant();
        participant.setAge(50);
        participant.setCity("City");
        participant.setName("Name");

        participantRepository.save(participant);

        Participant participant1 = new Participant();
        participant1.setAge(60);
        participant1.setCity("City1");
        participant1.setName("Name1");

        participantRepository.save(participant1);

        Participant participant2 = new Participant();
        participant2.setAge(70);
        participant2.setCity("City2");
        participant2.setName("Name2");

        participantRepository.save(participant2);

        Participant participant3 = new Participant();
        participant3.setAge(80);
        participant3.setCity("City2");
        participant3.setName("Name2");

        participantRepository.save(participant3);

        try{
            lottery.start();
        }catch (TooFewMembersException e) {
            Assertions.assertEquals("Too few members", e.getMessage());
        }
    }

    @Test
    @Transactional
    @Rollback
    public void lotteryCheckException() {
        Participant participant = new Participant();
        participant.setAge(50);
        participant.setCity("City");
        participant.setName("Name");

        participantRepository.save(participant);

        try{
            lottery.start();
        }catch (TooFewMembersException e) {
            Assertions.assertEquals("Too few members", e.getMessage());
        }
    }
}
