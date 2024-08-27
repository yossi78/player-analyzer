package com.playermaker.com.players_analyzer.model;

import lombok.Data;

import java.util.List;

@Data
public class PlayerRequest {
    private int requiredTopPlayers;
    private List<List<String>> participatedPlayers;

    public PlayerRequest(int requiredTopPlayers, List<List<String>> participatedPlayers) {
        this.requiredTopPlayers = requiredTopPlayers;
        this.participatedPlayers = participatedPlayers;
    }
}