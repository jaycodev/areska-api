package com.areska.shared.api;

import com.fasterxml.jackson.annotation.JsonPropertyOrder;

import lombok.AllArgsConstructor;
import lombok.Getter;

@Getter
@AllArgsConstructor
@JsonPropertyOrder({ "field", "message", "rejectedValue" })
public class ApiFieldError {
    private String field;
    private String message;
    private Object rejectedValue;
}
