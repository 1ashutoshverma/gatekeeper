package com.gatekeeper.gatekeeper_server.exception;

import jakarta.servlet.http.HttpServletRequest;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;

@ControllerAdvice
public class GlobalControllerExceptionHandler {

    @ExceptionHandler(UserNotFoundException.class)
    public String handleUserNotFoundException(
            UserNotFoundException ex,
            HttpServletRequest request
    ) {

        return "redirect:/error";
    }

    @ExceptionHandler(RuntimeException.class)
    public String handleRuntimeException(
            RuntimeException ex,
            HttpServletRequest request
    ) {
        return "redirect:/error";
    }

}
