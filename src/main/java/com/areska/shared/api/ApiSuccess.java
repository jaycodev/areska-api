package com.areska.shared.api;

import java.time.LocalDateTime;

import com.fasterxml.jackson.annotation.JsonPropertyOrder;

import lombok.Getter;

@Getter
@JsonPropertyOrder({ "success", "message", "data", "timestamp" })
public class ApiSuccess<T> {

    private final boolean success = true;
    private final String message;
    private final T data;
    private final LocalDateTime timestamp = LocalDateTime.now();

    public ApiSuccess(String message, T data) {
        this.message = message;
        this.data = data;
    }
}
