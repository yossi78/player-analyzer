package com.playermaker.com.players_analyzer.api;


import com.playermaker.com.players_analyzer.model.PlayerRequest;
import com.playermaker.com.players_analyzer.service.PlayerService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Map;

@RestController
@RequestMapping("/players")
public class PlayerController {

    private PlayerService playerService;


    @Autowired
    public PlayerController(PlayerService playerService){
        this.playerService=playerService;
    }

    @PostMapping("/top")
    public List<String> getTopPlayers(@RequestBody PlayerRequest playerRequest) {
        return playerService.getTopPlayers(playerRequest.getRequiredTopPlayers(), playerRequest.getParticipatedPlayers());
    }

    @PostMapping("/top/details")
    public List<Map.Entry<String, Integer>> getTopPlayersDetailed(@RequestBody PlayerRequest playerRequest) {
        return playerService.getTopPlayersDetails(playerRequest.getRequiredTopPlayers(), playerRequest.getParticipatedPlayers());
    }

}

