package com.practice.task.exception;

import org.springframework.http.HttpStatus;

public record TaskException(String message, Throwable cause, HttpStatus status) {

}
