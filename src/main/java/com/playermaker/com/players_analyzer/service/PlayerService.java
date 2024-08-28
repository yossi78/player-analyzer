package com.playermaker.com.players_analyzer.service;

import org.springframework.stereotype.Service;
import java.util.*;
import java.util.stream.Collectors;

@Service
public class PlayerService {

    public List<String> getTopPlayers(int n, List<List<String>> participatedPlayers) {
        Map<String, Integer> playerCountMap = new HashMap<>();
        for (List<String> game : participatedPlayers) {
            Set<String> uniquePlayers = new HashSet<>(game);
            for (String player : uniquePlayers) {
                playerCountMap.put(player, playerCountMap.getOrDefault(player, 0) + 1);
            }
        }
        return getPlaysByPlayingDesc(playerCountMap,n);
    }


    private List<String> getPlaysByPlayingDesc(Map<String, Integer> playerCountMap,int limit){
        return playerCountMap.entrySet()
                .stream()
                .sorted(Map.Entry.<String, Integer>comparingByValue().reversed())
                .limit(limit)
                .map(Map.Entry::getKey)
                .collect(Collectors.toList());
    }
}
