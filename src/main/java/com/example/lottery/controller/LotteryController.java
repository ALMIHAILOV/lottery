package com.example.lottery.controller;

import com.example.lottery.data.ParticipantRepository;
import com.example.lottery.data.WinnerRepository;
import com.example.lottery.model.Participant;
import com.example.lottery.model.Winner;
import com.example.lottery.service.Lottery;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Optional;

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
    @ResponseStatus(HttpStatus.CREATED)
    public Participant createParticipant(@RequestBody Participant participant) {
        return participantRepo.save(participant);
    }

    @GetMapping("/participant")
    public ResponseEntity<List<Participant>> getParticipant() {
        Optional<List<Participant>> optionalParticipantList = Optional.of((List<Participant>) participantRepo.findAll());
        return optionalParticipantList.map(participants -> new ResponseEntity<>(participants, HttpStatus.OK)).orElseGet(()
                -> new ResponseEntity<>(null, HttpStatus.NOT_FOUND));
    }

    @GetMapping("/start")
    public Winner startLottery() {
        return lottery.start();
    }

    @GetMapping("/winners")
    public ResponseEntity<List<Winner>> getWinners() {
        Optional<List<Winner>> optionalWinnerList = Optional.of((List<Winner>) winnerRepo.findAll());
        return optionalWinnerList.map(winners -> new ResponseEntity<>(winners, HttpStatus.OK)).orElseGet(()
                -> new ResponseEntity<>(null, HttpStatus.NOT_FOUND));
    }
}
