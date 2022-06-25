package com.example.lottery;

import com.example.lottery.exception.TooFewMembersException;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;
import org.springframework.boot.test.context.SpringBootTest;

@SpringBootTest
public class TooFewMembersExceptionTest {

    @Test
    public void exceptionTest() {
        Exception exception = Assertions.assertThrows(TooFewMembersException.class, () -> {
            throw new TooFewMembersException();
        });

        String expectedMessage = "Too few members";
        String actualMessage = exception.getMessage();
        Assertions.assertEquals(actualMessage, expectedMessage);
    }
}
