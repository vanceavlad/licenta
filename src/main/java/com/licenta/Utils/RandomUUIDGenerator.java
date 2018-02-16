package com.licenta.Utils;

import org.springframework.stereotype.Component;

import java.util.UUID;

@Component
public class RandomUUIDGenerator {

    public UUID getRandomUUID() {
        return UUID.randomUUID();
    }

}
