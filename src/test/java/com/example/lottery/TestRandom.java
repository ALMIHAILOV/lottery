package com.example.lottery;

import com.example.lottery.service.Random;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.RepeatedTest;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

@SpringBootTest
public class TestRandom {

    @Autowired
    Random random;

    @RepeatedTest(value = 10)
    public void getRandomTest() {
        int maxVal = (int)(Math.random() * 1000) ;
        int randomVal = random.getRandom(1, maxVal);

        Assertions.assertTrue(randomVal<=maxVal && randomVal>=0);
    }
}
