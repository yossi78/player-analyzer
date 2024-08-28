package com.playermaker.com.players_analyzer.exception;



import lombok.Data;

import java.util.Date;

@Data
public class ErrorDetails {
    private Date timestamp;
    private String message;
    private String details;

    public ErrorDetails(Date timestamp, String message, String details) {
        this.timestamp = timestamp;
        this.message = message;
        this.details = details;
    }

}
