package com.example.lottery.service;

import com.example.lottery.data.ParticipantRepository;
import com.example.lottery.data.WinnerRepository;
import com.example.lottery.exception.TooFewMembersException;
import com.example.lottery.model.Participant;
import com.example.lottery.model.Winner;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;

@Service
public class Lottery {

    private final ParticipantRepository participantRepo;
    private final WinnerRepository winnerRepo;
    private final Random random;
    public Lottery(ParticipantRepository participantRepo, Random random, WinnerRepository winnerRepo) {
        this.participantRepo = participantRepo;
        this.random = random;
        this.winnerRepo = winnerRepo;
    }


    public Winner start() {
        List<Participant> participants = new ArrayList<>();
        participantRepo.findAll().forEach(participants::add);
        int participantNumber = participants.size();
        int MIN_NUMBER_PARTICIPANT = 2;
        int MAX_WINNING_AMOUNT = 1000;
        if (participantNumber < MIN_NUMBER_PARTICIPANT) {
            throw new TooFewMembersException();
        }

        int winningAmount = random.getRandom(1, MAX_WINNING_AMOUNT);
        int winnerId = random.getRandom(0, participantNumber-1);

        Winner winner = new Winner();
        winner.setAge(participants.get(winnerId).getAge());
        winner.setName(participants.get(winnerId).getName());
        winner.setCity(participants.get(winnerId).getCity());
        winner.setAmount(winningAmount);

        participantRepo.deleteAll();
        winnerRepo.save(winner);

        return winner;
    }
}
