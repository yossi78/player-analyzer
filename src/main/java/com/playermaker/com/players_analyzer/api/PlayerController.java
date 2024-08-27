package com.playermaker.com.players_analyzer.api;


import com.playermaker.com.players_analyzer.model.PlayerRequest;
import com.playermaker.com.players_analyzer.service.PlayerService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/players")
public class PlayerController {

    @Autowired
    private PlayerService playerService;

    @PostMapping("/top")
    public List<String> getTopPlayers(@RequestBody PlayerRequest playerRequest) {
        return playerService.getTopPlayers(playerRequest.getRequiredTopPlayers(), playerRequest.getParticipatedPlayers());
    }
}

