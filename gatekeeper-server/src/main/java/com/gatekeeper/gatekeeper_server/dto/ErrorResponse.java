package com.gatekeeper.gatekeeper_server.dto;

import java.time.LocalDateTime;

import lombok.Data;

@Data
public class ErrorResponse {
    private String message;
    private int statusCode;
    private String path;
    private String timestamp;

    public ErrorResponse(String message, int statusCode, String path) {
        this.message = message;
        this.statusCode = statusCode;
        this.path = path;
        this.timestamp = LocalDateTime.now().toString();
    }

}
