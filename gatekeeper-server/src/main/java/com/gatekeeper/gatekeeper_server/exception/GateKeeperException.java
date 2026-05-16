package com.gatekeeper.gatekeeper_server.exception;

public class GateKeeperException extends RuntimeException{

    private final int statusCode;

    public GateKeeperException(String message, int statusCode) {
        super(message);
        this.statusCode = statusCode;
    }

    public int getStatusCode() {
        return statusCode;
    }
}
