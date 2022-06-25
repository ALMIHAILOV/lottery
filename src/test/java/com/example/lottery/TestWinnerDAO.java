package com.example.lottery;

import com.example.lottery.data.WinnerRepository;
import com.example.lottery.model.Winner;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.orm.jpa.DataJpaTest;
import org.springframework.test.annotation.Rollback;
import org.springframework.transaction.annotation.Transactional;

import java.util.ArrayList;
import java.util.List;

@DataJpaTest
public class TestWinnerDAO {

    @Autowired
    private WinnerRepository winnerRepository;

    @Test
    @Transactional
    @Rollback
    public void addWinnerTest() {
        Winner winner = new Winner();
        winner.setName("Name");
        winner.setAge(20);
        winner.setCity("City");
        winner.setAmount(500);

        winnerRepository.save(winner);

        List<Winner> winners = new ArrayList<>();
        winnerRepository.findAll().forEach(winners::add);

        Assertions.assertEquals(winner, winners.get(0));
    }
}
