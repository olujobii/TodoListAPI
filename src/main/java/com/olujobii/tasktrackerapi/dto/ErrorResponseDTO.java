package com.olujobii.tasktrackerapi.dto;

import org.springframework.http.HttpStatus;

import java.time.LocalDateTime;

public record ErrorResponseDTO(
        LocalDateTime timeStamp,
        HttpStatus httpStatus,
        String errorMessage
){}
