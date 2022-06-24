package com.example.lottery.service;

import org.springframework.stereotype.Service;
import org.springframework.web.client.RestTemplate;

@Service
public class Random {
    private final RestTemplate rest;

    public Random(RestTemplate rest) {
        this.rest = rest;
    }

    public Integer getRandom(int maxVal) {
        String url = "https://www.random.org/integers/?num=1&min=1&max="+ maxVal +"&col=1&base=10&format=plain&rnd=new";
        String r = rest.getForObject(url, String.class);
        return Integer.parseInt(r.trim());
    }
}

