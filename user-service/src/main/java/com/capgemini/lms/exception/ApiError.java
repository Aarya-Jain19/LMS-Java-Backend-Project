package com.capgemini.lms.exception;

import java.time.LocalDateTime;

public class ApiError {

    private String message;
    private int status;
    private LocalDateTime timestamp;

  
    public ApiError(String message, int status) {
        this.message = message;
        this.status = status;
        this.timestamp = LocalDateTime.now();
    }

    
    public ApiError() {
        this.timestamp = LocalDateTime.now();
    }

  
    public String getMessage() {
        return message;
    }

    public int getStatus() {
        return status;
    }

    public LocalDateTime getTimestamp() {
        return timestamp;
    }


    public void setMessage(String message) {
        this.message = message;
    }

    public void setStatus(int status) {
        this.status = status;
    }

    public void setTimestamp(LocalDateTime timestamp) {
        this.timestamp = timestamp;
    }
}