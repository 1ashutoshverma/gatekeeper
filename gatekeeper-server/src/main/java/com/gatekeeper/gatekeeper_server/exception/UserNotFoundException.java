package com.gatekeeper.gatekeeper_server.exception;

public class UserNotFoundException extends GateKeeperException {

    public UserNotFoundException(String message, int status) {
        super(message, status);
    }
}
