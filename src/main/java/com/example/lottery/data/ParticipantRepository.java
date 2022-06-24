package com.example.lottery.data;

import com.example.lottery.model.Participant;
import org.springframework.data.repository.CrudRepository;

public interface ParticipantRepository extends CrudRepository<Participant, Long> {
}
