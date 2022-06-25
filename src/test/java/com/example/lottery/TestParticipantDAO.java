package com.example.lottery;

import com.example.lottery.data.ParticipantRepository;
import com.example.lottery.model.Participant;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.orm.jpa.DataJpaTest;
import org.springframework.test.annotation.Rollback;
import org.springframework.transaction.annotation.Transactional;

import java.util.ArrayList;
import java.util.List;

@DataJpaTest
public class TestParticipantDAO {

    @Autowired
    private ParticipantRepository participantRepository;

    @Test
    @Transactional
    @Rollback
    public void testAddParticipant() {
        Participant participant = new Participant();
        participant.setAge(50);
        participant.setCity("City");
        participant.setName("Name");

        participantRepository.save(participant);

        List<Participant> participants = new ArrayList<>();
        participantRepository.findAll().forEach(participants::add);

        Assertions.assertEquals(participant, participants.get(0));
    }
}
