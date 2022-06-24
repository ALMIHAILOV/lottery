package com.example.lottery.service;

import com.example.lottery.data.ParticipantRepository;
import com.example.lottery.data.WinnerRepository;
import com.example.lottery.exception.TooFewMembersException;
import com.example.lottery.model.Participant;
import com.example.lottery.model.Winner;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Service;

import java.util.HashMap;
import java.util.Map;

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
        int participantNumber = Math.toIntExact(participantRepo.count());
        int MIN_NUMBER_PARTICIPANT = 2;
        int MIN_WINNING_AMOUNT = 0;
        int MAX_WINNING_AMOUNT = 1000;
        if (participantNumber < MIN_NUMBER_PARTICIPANT) {
            throw new TooFewMembersException();
        }

        System.out.println(participantRepo.findFirstByOrderByIdAsc().getId());
        int winningAmount = random.getRandom(MIN_WINNING_AMOUNT,MAX_WINNING_AMOUNT);
        long winnerId = random.getRandom(Math.toIntExact(participantRepo.findFirstByOrderByIdAsc().getId()),participantNumber+Math.toIntExact(participantRepo.findFirstByOrderByIdAsc().getId()));

        Winner winner = new Winner();
        winner.setAge(participantRepo.findById(winnerId).get().getAge());
        winner.setName(participantRepo.findById(winnerId).get().getName());
        winner.setCity(participantRepo.findById(winnerId).get().getCity());
        winner.setAmount(winningAmount);

        participantRepo.deleteAll();
        winnerRepo.save(winner);

        return winner;
    }
}
