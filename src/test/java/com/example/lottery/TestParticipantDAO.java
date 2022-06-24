package com.example.lottery;

import com.example.lottery.data.ParticipantRepository;
import com.example.lottery.model.Participant;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.annotation.Rollback;
import org.springframework.transaction.annotation.Transactional;
import org.springframework.util.Assert;

import java.util.ArrayList;
import java.util.List;

@SpringBootTest
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

        Assert.
    }
}
