package com.example.lottery;

import com.example.lottery.data.ParticipantRepository;
import com.example.lottery.data.WinnerRepository;
import com.example.lottery.model.Participant;
import com.example.lottery.model.Winner;
import com.fasterxml.jackson.databind.ObjectMapper;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.web.servlet.AutoConfigureMockMvc;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.boot.test.mock.mockito.MockBean;
import org.springframework.data.crossstore.ChangeSetPersister;
import org.springframework.http.MediaType;
import org.springframework.test.web.servlet.MockMvc;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

import static org.mockito.Mockito.when;
import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.*;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.jsonPath;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.status;


@SpringBootTest(webEnvironment = SpringBootTest.WebEnvironment.RANDOM_PORT)
@AutoConfigureMockMvc
public class LotteryControllerTest {
    @MockBean
    private WinnerRepository winnerRepository;
    @MockBean
    private ParticipantRepository participantRepository;
    @Autowired
    private MockMvc mockMvck;
    @Autowired
    private ObjectMapper objectMapper;

    @Test
    public void addParticipant() throws Exception {
        Participant participant = new Participant(1L, "Name", 50, "City");

        mockMvck.perform(post("/lottery/participant").contentType(MediaType.APPLICATION_JSON)
                .content(objectMapper.writeValueAsString(participant))).andExpect(status().isCreated());
    }

    @Test
    public void getAllParticipant() throws Exception {
        List<Participant> participants = new ArrayList<>(
                Arrays.asList(
                        new Participant(1L, "Name1", 10, "City1"),
                        new Participant(2L, "Name2", 20, "City2"),
                        new Participant(3L, "Name3", 30, "City3")
                )
        );
        when(participantRepository.findAll()).thenReturn(participants);
        mockMvck.perform(get("/lottery/participant"))
                .andExpect(status().isOk())
                .andExpect(jsonPath("$.size()").value(participants.size()));
    }

    @Test
    public void getAllWinner() throws Exception {
        List<Winner> winners = new ArrayList<>(
                Arrays.asList(
                        new Winner(1L, "Name1", 10, "City1", 100),
                        new Winner(2L, "Name2", 20, "City2", 200),
                        new Winner(3L, "Name3", 30, "City3", 300)
                )
        );
        when(winnerRepository.findAll()).thenReturn(winners);
        mockMvck.perform(get("/lottery/winners"))
                .andExpect(status().isOk())
                .andExpect(jsonPath("$.size()").value(winners.size()));
    }
}
