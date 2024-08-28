package com.playermaker.com.players_analyzer.service;
import org.junit.jupiter.api.Test;
import org.springframework.boot.test.context.SpringBootTest;
import java.util.Arrays;
import java.util.Collections;
import java.util.List;
import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertThrows;

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

    @Test
    void testGetTopPlayersWithNullParticipatedPlayers() {
        assertThrows(NullPointerException.class, () -> {
            playerService.getTopPlayers(3, null);
        });
    }


    @Test
    void testGetTopPlayersWithEmptyGameList() {
        List<List<String>> participatedPlayers = Collections.emptyList();
        List<String> result = playerService.getTopPlayers(3, participatedPlayers);
        assert result.isEmpty();
    }


    @Test
    void testGetTopPlayersWithEmptyPlayersInGame() {
        List<List<String>> participatedPlayers = Arrays.asList(
                Arrays.asList(),
                Arrays.asList("Messi", "Ronaldo", "Shalom")
        );
        List<String> result = playerService.getTopPlayers(2, participatedPlayers);
        assert result.size() == 2;
        assert result.contains("Ronaldo");
        assert result.contains("Shalom");
    }
}

