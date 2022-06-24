package com.example.lottery.controller;

import com.example.lottery.data.ParticipantRepository;
import com.example.lottery.data.WinnerRepository;
import com.example.lottery.model.Participant;
import com.example.lottery.model.Winner;
import com.example.lottery.service.Lottery;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/lottery")
public class LotteryController {

    private final ParticipantRepository participantRepo;
    private final WinnerRepository winnerRepo;
    private final Lottery lottery;

    public LotteryController(ParticipantRepository participantRepo, Lottery lottery, WinnerRepository winnerRepo) {
        this.participantRepo = participantRepo;
        this.lottery = lottery;
        this.winnerRepo = winnerRepo;
    }

    @PostMapping("/participant")
    public Participant createParticipant(@RequestBody Participant participant) {
        return participantRepo.save(participant);
    }

    @GetMapping("/participant")
    public List<Participant> getParticipant() {
        return (List<Participant>) participantRepo.findAll();
    }

    @GetMapping("/start")
    public Winner startLottery() {
        return lottery.start();
    }

    @GetMapping("/winners")
    public List<Winner> getWinners() {
        return (List<Winner>) winnerRepo.findAll();
    }
}
