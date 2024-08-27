package com.playermaker.com.players_analyzer.service;


import org.junit.jupiter.api.Test;
import org.springframework.boot.test.context.SpringBootTest;

import java.util.Arrays;
import java.util.List;

import static org.junit.jupiter.api.Assertions.assertEquals;

@SpringBootTest
class PlayerServiceTests {

    private final PlayerService playerService = new PlayerService();

    @Test
    void testGetTopPlayers() {
        List<List<String>> participatedPlayers = Arrays.asList(
                Arrays.asList("Sharon", "Shalom", "Sharon", "Ronaldo"),
                Arrays.asList("Sharon", "Shalom", "Myke", "Ronaldo"),
                Arrays.asList("Yechiel", "Sivan", "Messi", "Ronaldo"),
                Arrays.asList("Yechiel", "Assaf", "Shalom", "Ronaldo")
        );

        List<String> topPlayers = playerService.getTopPlayers(2, participatedPlayers);
        assertEquals(Arrays.asList("Ronaldo", "Shalom"), topPlayers);
    }
}
