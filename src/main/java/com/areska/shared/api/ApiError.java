package com.areska.shared.api;

import java.time.LocalDateTime;
import java.util.List;

import com.fasterxml.jackson.annotation.JsonPropertyOrder;

import lombok.Getter;

@Getter
@JsonPropertyOrder({ "success", "status", "message", "path", "timestamp", "errors" })
public class ApiError {

    private final boolean success = false;
    private final int status;
    private final String message;
    private final String path;
    private final LocalDateTime timestamp  = LocalDateTime.now();
    private final List<ApiFieldError> errors;

    public ApiError(int status, String message, String path, List<ApiFieldError> errors) {
        this.status = status;
        this.message = message;
        this.path = path;
        this.errors = errors;
    }

    public ApiError(int status, String message, String path) {
        this(status, message, path, null);
    }
}
